import torch
import torch.nn as nn
import torch.nn.functional as F
from attention import MultiHeadSelfAttention

class TransformerBlock(nn.Module):
    def __init__(self, embed_dim, num_heads, ff_hidden_dim, dropout=0.1):
        super().__init__()
        self.attention = MultiHeadSelfAttention(embed_dim, num_heads)
        self.norm1 = nn.LayerNorm(embed_dim)
        self.norm2 = nn.LayerNorm(embed_dim)

        # Position-wise feed-forward network
        self.ff = nn.Sequential(
            nn.Linear(embed_dim, ff_hidden_dim),
            nn.ReLU(),
            nn.Linear(ff_hidden_dim, embed_dim)
        )
        self.dropout = nn.Dropout(dropout)

    def forward(self, x):
        # Multi-head attention sub-layer with residual connection and layer norm
        attn_out = self.attention(x)
        x = self.norm1(x + self.dropout(attn_out))

        # Feed-forward sub-layer with residual connection and layer norm
        ff_out = self.ff(x)
        x = self.norm2(x + self.dropout(ff_out))
        return x


class TransformerModel(nn.Module):
    def __init__(self, vocab_size, embed_dim, num_heads, ff_hidden_dim, num_layers, max_seq_len, dropout=0.1):
        super().__init__()
        from embedding import TokenEmbedding, PositionalEncoding

        self.token_embedding = TokenEmbedding(vocab_size, embed_dim)
        self.pos_encoding = PositionalEncoding(embed_dim, max_len=max_seq_len)

        self.layers = nn.ModuleList([
            TransformerBlock(embed_dim, num_heads, ff_hidden_dim, dropout)
            for _ in range(num_layers)
        ])

        # Final linear layer to project transformer output to vocabulary size for prediction
        self.fc_out = nn.Linear(embed_dim, vocab_size)

    def forward(self, x):
        # x shape: (batch_size, seq_len) - token IDs
        x = self.token_embedding(x)            # (batch_size, seq_len, embed_dim)
        x = self.pos_encoding(x)               # add positional encoding

        for layer in self.layers:
            x = layer(x)                       # pass through transformer blocks

        logits = self.fc_out(x)                 # (batch_size, seq_len, vocab_size)
        return logits

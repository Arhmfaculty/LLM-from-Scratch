import torch
import torch.nn as nn
import math

class TokenEmbedding(nn.Module):
    def __init__(self, vocab_size, embed_dim):
        super().__init__()
        # Embedding layer maps token IDs to vectors
        self.embedding = nn.Embedding(vocab_size, embed_dim)

    def forward(self, tokens):
        # tokens shape: (batch_size, seq_len)
        return self.embedding(tokens)  # returns shape: (batch_size, seq_len, embed_dim)


class PositionalEncoding(nn.Module):
    def __init__(self, embed_dim, max_len=5000):
        super().__init__()
        # Create constant positional encodings matrix with shape (max_len, embed_dim)
        pos_encoding = torch.zeros(max_len, embed_dim)
        position = torch.arange(0, max_len).unsqueeze(1).float()
        div_term = torch.exp(torch.arange(0, embed_dim, 2).float() * (-math.log(10000.0) / embed_dim))

        pos_encoding[:, 0::2] = torch.sin(position * div_term)  # even indices
        pos_encoding[:, 1::2] = torch.cos(position * div_term)  # odd indices
        pos_encoding = pos_encoding.unsqueeze(0)  # add batch dimension

        # Register as buffer so it's saved and moved with the model but not trained
        self.register_buffer('pos_encoding', pos_encoding)

    def forward(self, x):
        # x shape: (batch_size, seq_len, embed_dim)
        seq_len = x.size(1)
        # Add positional encoding up to the sequence length
        return x + self.pos_encoding[:, :seq_len, :]

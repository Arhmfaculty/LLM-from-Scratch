import torch.nn as nn
import torch.optim as optim
from utils import SimpleTokenizer, get_batch
from transformer import TransformerModel
import config as config
import torch

# Load data (needed to initialize the tokenizer)
with open("tiny_text.txt", "r") as f:
    text = f.read()

# Initialize tokenizer and set vocab size
tokenizer = SimpleTokenizer(text)
config.vocab_size = tokenizer.vocab_size

stoi = tokenizer.stoi
itos = tokenizer.itos

# Encode full dataset (data can also be made global if needed for other functions)
data = tokenizer.encode(text)

# Initialize model (model should also be globally accessible for generation)
model = TransformerModel(
    vocab_size=config.vocab_size,
    embed_dim=config.embed_dim,
    num_heads=config.num_heads,
    ff_hidden_dim=config.ff_hidden_dim,
    num_layers=config.num_layers,
    max_seq_len=config.max_seq_len,
    dropout=config.dropout,
).to(config.device)


# Training function
def train():
    optimizer = optim.Adam(model.parameters(), lr=config.learning_rate)
    criterion = nn.CrossEntropyLoss()
    
    model.train()
    steps_per_epoch = len(data) // (config.batch_size * config.max_seq_len)

    for epoch in range(config.num_epochs):
        epoch_loss = 0
        for step in range(steps_per_epoch):
            x_batch, y_batch = get_batch(data, config.batch_size, config.max_seq_len, config.device)

            optimizer.zero_grad()
            logits = model(x_batch)
            loss = criterion(logits.view(-1, config.vocab_size), y_batch.view(-1))
            loss.backward()
            optimizer.step()

            epoch_loss += loss.item()

        if epoch % 2 == 0:
            avg_loss = epoch_loss / steps_per_epoch
            print(f"Epoch {epoch} - Loss: {avg_loss:.4f}")


if __name__ == "__main__":
    train()


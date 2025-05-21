# Inside config.py
import torch # Add this line

# Configuration parameters
learning_rate = 0.001
batch_size = 32
max_seq_len = 128
embed_dim = 256
num_heads = 8
ff_hidden_dim = 512
num_layers = 6
num_epochs = 100
dropout = 0.1
device = "cuda" if torch.cuda.is_available() else "cpu"

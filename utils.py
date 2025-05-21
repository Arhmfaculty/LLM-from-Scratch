import torch

class SimpleTokenizer:
    def __init__(self, text):
        # Create vocab from unique characters for simplicity
        chars = sorted(list(set(text)))
        self.stoi = {ch: i for i, ch in enumerate(chars)}
        self.itos = {i: ch for ch, i in self.stoi.items()}
        self.vocab_size = len(chars)

    def encode(self, text):
        # Convert string to list of token ids
        return [self.stoi[ch] for ch in text]

    def decode(self, tokens):
        # Convert list of token ids back to string
        return ''.join([self.itos[t] for t in tokens])

def get_batch(data, batch_size, seq_len, device):
    # data: list of token ids
    inputs = []
    targets = []
    for _ in range(batch_size):
        start_idx = torch.randint(0, len(data) - seq_len - 1, (1,)).item()
        input_seq = data[start_idx:start_idx + seq_len]
        target_seq = data[start_idx + 1:start_idx + seq_len + 1]

        inputs.append(input_seq)
        targets.append(target_seq)

    # Convert to tensors
    x = torch.tensor(inputs, dtype=torch.long).to(device)
    y = torch.tensor(targets, dtype=torch.long).to(device)
    return x, y

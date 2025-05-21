# === Helper Functions ===

# Encode: text to token IDs
def encode(text):
    return [stoi[c] for c in text if c in stoi]

# Decode: token IDs to text
def decode(indices):
    return ''.join([itos[i] for i in indices])

# Generate text given a prompt
@torch.no_grad()
def generate(prompt, max_tokens=100):
    model.eval()
    # Use config.device which is globally available
    input_ids = torch.tensor([encode(prompt)], dtype=torch.long).to(config.device)

    for _ in range(max_tokens):
        # Use config.max_seq_len instead of the undefined block_size
        input_chunk = input_ids[:, -config.max_seq_len:] if input_ids.size(1) > config.max_seq_len else input_ids
        logits = model(input_chunk)
        logits = logits[:, -1, :]  # take the last token's logits
        probs = torch.softmax(logits, dim=-1)
        next_token = torch.multinomial(probs, num_samples=1)
        input_ids = torch.cat([input_ids, next_token], dim=1)

    return decode(input_ids[0].tolist())

print("🧠 Mini LLM Interactive Mode (type 'exit' to quit)")

while True:
    prompt = input(">>> ")
    if prompt.lower() in {"exit", "quit"}:
        break
    output = generate(prompt, max_tokens=100)
    print("\n📝 Output:\n" + output + "\n")


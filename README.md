#  LLM-from-Scratch

A simple and extensible transformer-based Language Model built entirely from scratch in PyTorch, trained on the Tiny Shakespeare dataset. This project is part of my ongoing exploration into the inner workings of LLMs, with a strong focus on optimization.

---

##  Project Overview

This repository is a minimal yet complete implementation of a transformer model, covering all the core components of modern LLMs:

- Tokenization (character-level)
- Positional Encoding
- Multi-head Self-Attention
- Transformer Blocks
- Causal Masking
- Training loop with CrossEntropy loss
- Sampling & interactive generation

The goal is not just to train a small LLM, but to understand *how* each building block contributes to the model’s performance, generalization, and learning stability — essential for trustworthy and secure model design.

---

## Academic Context

This project ties directly into my academic focus: building secure, explainable, and efficient AI models. It complements my broader research interests in:

- Model robustness and interpretability
- Secure machine learning and data privacy
- Low-level system understanding of ML architectures
- Exploring how LLMs can be optimized for constrained environments
- 
---

##  Setup & Training

### Requirements

- Python 3.8+
- PyTorch
- tqdm (optional for progress bars)

### Install dependencies

```bash
pip install torch
```

## Contributions
Pull requests are welcome! Feel free to fork this repo and experiment with:

- Byte-pair tokenization

- Rotary or relative position embeddings

- Training on new datasets

- Adding evaluation metrics (perplexity, BLEU, etc.)

- Performance tuning for different hardware



## 👨‍🎓 About Me
I’m a Computer Engineering student and researcher focused on AI security, LLM interpretability, and hardware-software co-design for intelligent systems. This project is part of my independent study into building trustable and efficient AI from the ground up.
Feel free to connect on LinkedIn or follow my technical blogs on Hashnode where I write about LLMs, security, and embedded AI.

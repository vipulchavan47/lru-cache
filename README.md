# LRU Cache Implementation (Java)

A thread-safe LRU (Least Recently Used) Cache implemented in Java using HashMap and Doubly Linked List.

## Features
- O(1) get and put operations
- Thread-safe using ReentrantLock

## Concepts Used
- HashMap for constant-time access
- Doubly Linked List for eviction order
- Concurrency handling with locks

## How to Run
```bash
javac src/Main.java
java src.Main

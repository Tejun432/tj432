
# Huffman Coding

This project implements **Huffman Coding**, an algorithm used for data compression. It includes methods for encoding and decoding text files using Huffman trees to efficiently represent characters based on their frequencies.

## Features:
- **Encoding**: Compresses a file by assigning shorter binary codes to frequently occurring characters and longer codes to less frequent characters.
- **Decoding**: Reconstructs the original file from its encoded binary representation using the Huffman tree.
- **File Handling**: Supports reading and writing both encoded and decoded files in binary format.

## How Huffman Coding Works:
1. **Frequency Analysis**: The characters in the input file are counted to determine their frequencies.
2. **Tree Construction**: A binary tree (Huffman Tree) is built where each leaf node represents a character, and its path determines the binary encoding.
3. **Encoding**: The file is encoded by replacing each character with its corresponding binary code from the Huffman tree.
4. **Decoding**: The encoded binary file is decoded by traversing the Huffman tree, reconstructing the original text.

## Methods:
- **`encode(String encodedFile)`**: Encodes the file and writes the compressed output to the specified encoded file.
- **`decode(String encodedFile, String decodedFile)`**: Decodes the encoded file and writes the decompressed output to the specified decoded file.
- **`makeSortedList()`**: Creates a list of characters and their frequencies sorted by frequency.
- **`makeTree()`**: Constructs the Huffman tree from the sorted character frequencies.
- **`makeEncodings()`**: Generates the binary encoding for each character based on the Huffman tree.

## File Handling:
- **Input File**: The file to be encoded should contain text data.
- **Encoded File**: The file containing the compressed binary encoding.
- **Decoded File**: The file where the decompressed text will be stored.



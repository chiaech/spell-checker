# Assignment 1: Spell Checker
Analucía Esparza-Chávez

In this project, I generated a spell checker using external data. I create either a Trie object or a Tree object, depending on the value read in from the configuration file, "a1properties.txt" and depenting on the type, I insert each word into the data strcuture from the "english.0" file. If it is of Tree type, words are inserted word by word. If it is of Trie type, words are inserted letter by letter. If no value is specified, the default tree that is created is of type Trie. I then read data from an input file "input.txt" that looks for the word in the tree, word by word. If the word is found, the word is returned and if it is not found, a suggested word is returned. All returned words are written to an output file "ouput.txt".


## To compile
  javac CS245A1.java

## To run
  java CS245A1 input.txt output.txt

## Analysis
Overall, the Trie tree implementation is faster. A Trie tree has a runtime of O(m), with m being the length of the word passed in. The Tree tree has a runtime of O(n) because it inserts or finds depending on the size of the data while a Trie tree's insert and find depend on the length of the word and worst case you would have to keep going until the last letter. In addition, you can see in your terminal that it takes longer for the Tree tree implementation to finish than the Trie tree implementation.

## Extra Credit
I can read the english.0 file directly from Github.

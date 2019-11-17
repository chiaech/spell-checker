# Assignment 1: Spell Checker
Analucía Esparza-Chávez

In this project, I generated a spell checker using external data. I create either a Trie object or a Tree object, depending on the value read in from the configuration file, "a1properties.txt" and depenting on the type, I insert each word into the data strcuture from the "english.0" file. If it is of Tree type, words are inserted word by word. If it is of Trie type, words are inserted letter by letter. If no value is specified, the default tree that is created is of type Trie. I then read data from an input file "input.txt" that looks for the word in the tree, word by word. If the word is found, the word is returned and if it is not found, a suggested word is returned. All returned words are written to an output file "ouput.txt".


## To compile
  javac CS245A1.java

## To run
  java CS245A1 input.txt output.txt

## Analysis
Overall, the trie tree implementation is faster. 

## Extra Credit
I can read the english.0 file directly from Github.

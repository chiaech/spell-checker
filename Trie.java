public class Trie implements Search { 
      
    // Alphabet size (# of symbols) 
    //size is 27 to take apostrophes into account

    // trie node 
    private class TrieNode { 
        TrieNode[] children = new TrieNode[27]; 
       
        // isEndOfWord is true if the node represents 
        // end of a word 
        boolean isEndOfWord; 
          
        public TrieNode(){ 
            isEndOfWord = false; 

            for (int i = 0; i <= 27; i++) 
                children[i] = null; 
        } 
    }; 
       
    TrieNode root = null;  
      
    // If not present, inserts key into trie 
    // If the key is prefix of trie node,  
    // just marks leaf node 
    public void insert(String item) { 
        int length = item.length(); 
        int index; 
       
        TrieNode current = root; 
       
        for (int i = 0; i < length; i++) { 
            //index for char using ascii values
            //TODO fix for apostrophes
            index = item.charAt(i) - 'a'; 

            //if there is no node at that idex, create one
            if (current.children[index] == null) 
                current.children[index] = new TrieNode(); 
       
            //if there is a node at that index, current becomes a leaf node
            current = current.children[index]; 
        } 
       
        // mark the last node as a leaf 
        current.isEndOfWord = true; 
    } 
       
    // Returns true if key presents in trie, else false 
    public String find(String item) { 
        int length = item.length(); 
        int index; 
        TrieNode current = root; 
       
        for (int i = 0; i < length; i++) { 
            index = item.charAt(i) - 'a'; 
       
            if (current.children[index] == null) {
                return item;
            } else if (current == current.children[index]){
                return item;
            }

            // if we reach the end of the word, return a suggestion
            // else find another word and repeat
            current = current.children[index]; 
        } 
               
        if (current != null && current.isEndOfWord){
            return item;
        }
        return item;

    } 
}
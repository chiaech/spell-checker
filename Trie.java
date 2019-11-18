public class Trie implements Search { 
      
    static final int size = 27;

    private class TrieNode { 
        TrieNode[] children = new TrieNode[size]; 
       
        boolean isEndOfWord; 
          
        public TrieNode() { 
            isEndOfWord = false; 

            for (int i = 0; i < size; i++) 
                children[i] = null; 
        } 
    }; 
       
    TrieNode root = new TrieNode();  

    public void insert(String item) {
        int i;
        int length = item.length();
        int index;
        TrieNode current = root;

        for (i = 0; i < length; i++) {
            index = item.charAt(i) - 'a';
            if (index == -58) {
                index = 26;
            } 

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    } 

    public String find(String item) { 
        int length = item.length(); 
        int index;
        TrieNode current = root; 
        StringBuilder suggest = new StringBuilder();
       
        for (int i = 0; i < length; i++) {
            index = item.charAt(i) - 'a';
            if (index == -58) {
                index = 26;
            }

            if (current.children[index] == null) {
                return ((suggestion(suggest, current))).toString();
            } 

            if ((current.children[index] != null) && index == 26) {
                suggest.append((char)39);
                i--;
            } else {
                suggest.append((char)(index+97));
            }

            current = current.children[index];
        }

        if (current != null && current.isEndOfWord) {
            return item;
        }

        if (item != ""){
            return ((suggestion(suggest, current))).toString();
        }
        return item;
    } 

    public String suggestion(StringBuilder suggest, TrieNode current) {
        int index = 0;

        while(!current.isEndOfWord) {
            if (current.children[index] != null) {
                suggest.append((char)(index+97));
                current = current.children[index];
                index = 0;
            } else {
                index++;
            }
        }
        return suggest.toString();
    }
}
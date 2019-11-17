public class Trie implements Search { 
      
    static final int size = 27;

    private class TrieNode { 
        TrieNode[] children = new TrieNode[size]; 
       
        boolean isEndOfWord; 
          
        public TrieNode(){ 
            isEndOfWord = false; 

            for (int i = 0; i < size; i++) 
                children[i] = null; 
        } 
    }; 
       
    TrieNode root = new TrieNode();  

    public void insert(String item){
        int i;
        int length = item.length();
        int index;
        TrieNode current = root;

        for (i = 0; i < length; i++){
            index = item.charAt(i) - 'a';
            if (index == -58){
                index = 26;
            } 
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current = current.children[index];
        }
        current.isEndOfWord = true;
    } 

    public String find(String item) { 
        int length = item.length(); 
        int index;
        TrieNode current = root; 
        //TrieNode previous = root;
        StringBuilder suggest = new StringBuilder();
       
        for (int i = 0; i < length; i++) {
            //suggest = suggest+item.charAt(i);
            index = item.charAt(i) - 'a';
            if (index == -58){
                index = 26;
            } 

            //previous = current; 
            // if (current.children[index] == null){
            //     if (!current.isEndOfWord){
            //     //     return suggest.toString();
            //     // } else {
            //         return suggestion(suggest, current);
            //     }
            // }
            
            if (index == 26)
                suggest.append((char)39);
            else 
                suggest.append((char)(index+97));

            //suggest.append(index);
            current = current.children[index];
        }

        if (current != null && current.isEndOfWord){
            return item;
        } else {
            return suggestion(suggest, current);
        }
    } 

    public String suggestion(StringBuilder suggest, TrieNode current){
        boolean found = false;
        int index = 0;

        while(!found){
            for (int i = 0; i < size; i++){
                if (current.children[i] != null){
                    index = i;
                }
            } 
            if (index == 26)
                suggest.append((char)39);
            else 
                suggest.append((char)(index+97));

            //suggest.append((char)index);
            current = current.children[index];
            if(current.isEndOfWord){
                found = true;
            }
        }
        return suggest.toString();
    }
}
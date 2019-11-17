public class Tree implements Search {

    private class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;

        TreeNode(String item) {
            data = item;
            left = null;
            right = null;
        }
    }

    TreeNode root = null;

    @Override
    public String find(String item) {
        return find(item, root);
    }

    public String find(String item, TreeNode node) {
       // if (node.left == null && node.right == null) {
        //    return node.data;
       // } else 
        if (item.equals(node.data)) {
            return node.data;
        } else if ((item.compareTo(node.data) < 0) && node.left == null){
            return node.data;
        } else if ((item.compareTo(node.data) > 0) && node.right == null){
            return node.data;
        } else if(item.compareTo(node.data) < 0) {
            return find(item, node.left);
        } else {
            return find(item, node.right);
        }
    }

    @Override
    public void insert(String item) {
        root = insert(item, root);
    }

    public TreeNode insert(String item, TreeNode node) {
        if (node == null) {
            node = new TreeNode(item);
        } else if (item.compareTo(node.data) < 0) {
            node.left = insert(item, node.left);
        } else if (item.compareTo(node.data) > 0) {
            node.right = insert(item, node.right);
        } 
        return node;

    }
}
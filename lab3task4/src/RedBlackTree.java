public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{

        String key;
        Integer value;
        Node left;
        Node right;
        boolean color;
    }

    private boolean isRed(Node x){
        if (x == null) return false;
        else return x.color;
    }

    private Node rotateLeft (Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
}

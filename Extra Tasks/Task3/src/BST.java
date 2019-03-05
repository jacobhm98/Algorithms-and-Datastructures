
public class BST <Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node (Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }
    public Value get(Key key){
    return get(root, key);
    }

    private Value get(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.value;
    }



    public void put(Key key, Value value){
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value){
        if (x == null) return new Node (key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if (x.right == null) return x;
        return max(x.right);
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("Key is null");
        return get(key) != null;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high){
        Queue<Key> queue = new Queue();
        keys(root, queue, low, high);
        return queue;
    }
    private void keys(Node x, Queue queue, Key low, Key high){
        if (x == null) return;
        int cmplow = low.compareTo(x.key);
        int cmphigh = high.compareTo(x.key);
        if (cmplow < 0) keys(x.left, queue, low, high);
        if (cmplow <= 0 && cmphigh >= 0) queue.enqueue(x.key);
        if (cmphigh > 0) keys(x.right, queue, low, high);
    }

}

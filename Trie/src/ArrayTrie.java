/**
 * Date: 2020/2/22 10:38 下午
 *
 * @author 3zZ.
 */
public class ArrayTrie {
    private class Node{
        public boolean isWord;
        public Node[] next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new Node[26];
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public ArrayTrie(){
        root = new Node();
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null){
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }
}

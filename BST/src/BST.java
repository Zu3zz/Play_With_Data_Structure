/**
 * Date: 2020/1/28 12:44 上午
 * 此二分搜索树中不包含重复元素
 *
 * @author 3zZ.
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 返回二叉搜索树的大小
     *
     * @return 返回节点的个数
     */
    public int size() {
        return size;
    }

    /**
     * 返回二叉搜索树是否为空
     *
     * @return 空为true 非空为false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     *
     * @param e 需要添加的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E, 递归的形式
     *
     * @param node 需要为根的节点
     * @param e    需要添加的元素大小
     * @return 返回插入新节点后二分搜索树的跟
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看二分搜索树中是否包含元素e
     * @param e 需要查找的元素
     * @return 如果存在就返回true
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e, 递归的形式
     * @param node 需要查找的根节点
     * @param e 需要查询的元素值
     * @return 返回是否存在
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else { // e.compareTo(node.e) > 0
            return contains(node.right, e);
        }
    }

}

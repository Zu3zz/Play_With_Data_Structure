import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     *
     * @param e 需要查找的元素
     * @return 如果存在就返回true
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e, 递归的形式
     *
     * @param node 需要查找的根节点
     * @param e    需要查询的元素值
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

    /**
     * 二叉搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉搜索树, 递归算法
     *
     * @param node 此轮遍历的根节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归的方式实现前序遍历，使用stack进行辅助
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二叉搜索树, 递归算法
     *
     * @param node 此轮遍历的根节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(node.e);
        inOrder(root.right);
    }

    /**
     * 二叉搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二叉搜索树, 递归算法
     *
     * @param node 此轮遍历的根节点
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素，递归的形式
     *
     * @return 返回最左子树的元素值
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最小元素，非递归的形式
     *
     * @return 返回最左子树的元素值
     */
    public E minimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimumNR(root).e;
    }

    private Node minimumNR(Node node) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /**
     * 寻找二分搜索树的最大元素，递归的形式
     *
     * @return 返回最左子树的元素值
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 寻找二分搜索树的最大元素，非递归的形式
     *
     * @return 返回最左子树的元素值
     */
    public E maximumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximumNR(root).e;
    }

    private Node maximumNR(Node node) {
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     *
     * @return 返回最小值
     */
    public E removeMin() {
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     *
     * @param node 当前需要进行操作的根节点
     * @return 返回删除节点后新的二叉搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在的节点，返回最大值
     *
     * @return 返回最大值
     */
    public E removeMax() {
        E ret = maximum();
        removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     *
     * @param node 当前需要进行操作的根节点
     * @return 返回删除节点后新的二叉搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e 需要被删除的节点元素值
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     *
     * @param node 目标的根节点
     * @param e    需要删除的元素值
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {// e == node.e
            // 待删除的节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除的节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}

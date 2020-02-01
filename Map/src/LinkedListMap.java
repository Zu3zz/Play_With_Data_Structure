/**
 * Date: 2020/2/1 5:17 下午
 *
 * @author 3zZ.
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 遍历链表 找到相应的key节点对应的value
     *
     * @param key 需要查找的节点的key值
     * @return 返回当前节点
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    /**
     * 添加一组键值对
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * 删除一组键值对
     *
     * @param key 需要删除的键
     * @return 返回对应的值
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    /**
     * 是否包含相应的键值
     *
     * @param key 需要查询的键
     * @return 返回是否存在
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * 获取相应键的值
     *
     * @param key 需要查询的键
     * @return 返回对应的值
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 对于指定的key，赋上一个新值
     *
     * @param key      需要修改的key
     * @param newValue 需要被修改的value
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = newValue;
    }

    /**
     * 返回映射的大小
     *
     * @return 返回映射的大小
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断map是否为空
     *
     * @return 返回map是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

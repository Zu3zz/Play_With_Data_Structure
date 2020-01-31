/**
 * Date: 2020/1/31 10:00 下午
 *
 * @author 3zZ.
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表元素的个数
     *
     * @return 链表元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return True则为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 练习用
     *
     * @param index 需要添加新节点的文职
     * @param e     需要添加新元素的大小
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index. ");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加新元素
     *
     * @param e 需要添加的元素的值
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     *
     * @param e 需要添加的新元素大小
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     * 练习用
     *
     * @param index 需要获得的链表位置
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index. ");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素
     * 练习用
     *
     * @param index 需要获得的链表位置
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed. Illegal index. ");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 需要查找的元素
     * @return 返回true or false
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除索引为index的元素
     * 练习用
     *
     * @param index 需要删除的元素的索引
     * @return 返回被删除的索引位置的元素值
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index. ");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     * @param e 需要被删除的元素
     */
    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            stringBuilder.append(cur).append(" -> ");
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}

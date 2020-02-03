/**
 * Date: 2020/2/3 11:40 下午
 *
 * @author 3zZ.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    private MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    /**
     * 返回stack的大小
     *
     * @return stack的大小
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 返回stack是否为空
     *
     * @return true为空 false为非空
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 向queue顶部压入一个元素
     *
     * @param e 需要push的元素值
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 取当前队列顶元素
     *
     * @return 栈顶元素的值
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * 出队操作
     *
     * @return 队列顶元素的值
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }
}


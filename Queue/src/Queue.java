/**
 * Date: 2020/1/22 3:43 下午
 *
 * @author 3zZ.
 */
public interface Queue<E> {

    /**
     * 返回stack的大小
     *
     * @return stack的大小
     */
    int getSize();

    /**
     * 返回stack是否为空
     *
     * @return true为空 false为非空
     */
    boolean isEmpty();

    /**
     * 向queue顶部压入一个元素
     *
     * @param e 需要push的元素值
     */
    void enqueue(E e);

    /**
     * 取当前队列顶元素
     *
     * @return 栈顶元素的值
     */
    E getFront();

    /**
     * 出队操作
     *
     * @return 队列顶元素的值
     */
    E dequeue();
}

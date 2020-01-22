/**
 * Date: 2020/1/22 2:32 下午
 *
 * @author 3zZ.
 */
public interface Stack<E> {
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
     * 向stack顶部压入一个元素
     *
     * @param e 需要push的元素值
     */
    void push(E e);

    /**
     * 取当前栈顶元素
     *
     * @return 栈顶元素的值
     */
    E peek();

    /**
     * 弹出当前栈顶的元素
     *
     * @return 返回栈顶元素的值
     */
    E pop();
}

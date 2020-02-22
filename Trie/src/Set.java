/**
 * Date: 2020/2/22 5:53 下午
 *
 * @author 3zZ.
 */
public interface Set<E> {
    /**
     * 添加元素
     *
     * @param e 需要添加的元素
     */
    void add(E e);

    /**
     * 删除元素
     *
     * @param e 需要删除的元素
     */
    void remove(E e);

    /**
     * 查询是否包含某元素
     *
     * @param e 需要查询的元素
     * @return 返回是否包含此元素
     */
    boolean contains(E e);

    /**
     * 获取集合的大小
     *
     * @return 返回集合大小
     */
    int getSize();

    /**
     * 判断集合是否为空
     *
     * @return 返回集合是否为空
     */
    boolean isEmpty();
}

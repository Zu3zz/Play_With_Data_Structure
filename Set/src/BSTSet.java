/**
 * Date: 2020/1/31 9:35 下午
 *
 * @author 3zZ.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    /**
     * 添加元素
     *
     * @param e 需要添加的元素
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 删除元素
     *
     * @param e 需要删除的元素
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 查询是否包含某元素
     *
     * @param e 需要查询的元素
     * @return 返回是否包含此元素
     */
    @Override
    public boolean contains(E e) {
        return false;
    }

    /**
     * 获取集合的大小
     *
     * @return 返回集合大小
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 判断集合是否为空
     *
     * @return 返回集合是否为空
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

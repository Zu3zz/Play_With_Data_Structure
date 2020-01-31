/**
 * Date: 2020/1/31 10:02 下午
 *
 * @author 3zZ.
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;
    public LinkedListSet(){
        list = new LinkedList<>();
    }
    /**
     * 添加元素
     *
     * @param e 需要添加的元素
     */
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    /**
     * 删除元素
     *
     * @param e 需要删除的元素
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 查询是否包含某元素
     *
     * @param e 需要查询的元素
     * @return 返回是否包含此元素
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 获取集合的大小
     *
     * @return 返回集合大小
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断集合是否为空
     *
     * @return 返回集合是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

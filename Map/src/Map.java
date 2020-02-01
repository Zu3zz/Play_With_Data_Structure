/**
 * Date: 2020/2/1 4:27 下午
 *
 * @author 3zZ.
 */
public interface Map<K, V> {
    /**
     * 添加一组键值对
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 删除一组键值对
     *
     * @param key 需要删除的键
     * @return 返回对应的值
     */
    V remove(K key);

    /**
     * 是否包含相应的键值
     *
     * @param key 需要查询的键
     * @return 返回是否存在
     */
    boolean contains(K key);

    /**
     * 获取相应键的值
     *
     * @param key 需要查询的键
     * @return 返回对应的值
     */
    V get(K key);

    /**
     * 修改键值对
     *
     * @param key   需要修改的key
     * @param value 需要被修改的value
     */
    void set(K key, V value);

    /**
     * 返回映射的大小
     *
     * @return 返回映射的大小
     */
    int getSize();

    /**
     * 判断map是否为空
     *
     * @return 返回map是否为空
     */
    boolean isEmpty();
}

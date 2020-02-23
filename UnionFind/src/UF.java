/**
 * Date: 2020/2/22 11:29 下午
 *
 * @author 3zZ.
 */
public interface UF {
    /**
     * 查看并查集中元素的个数
     *
     * @return 返回元素的个数
     */
    int getSize();

    /**
     * 查询两个元素是否相连
     *
     * @param p 需要查找的第一个元素
     * @param q 需要查找的第二个元素
     * @return 返回是否相连
     */
    boolean isConnected(int p, int q);

    /**
     * 将两个元素相连接
     *
     * @param p 需要连接的第一个元素
     * @param q 需要连接的第二个元素
     */
    void unionElements(int p, int q);
}

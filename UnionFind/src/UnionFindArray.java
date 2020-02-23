/**
 * Date: 2020/2/22 11:58 下午
 *
 * @author 3zZ.
 */
public class UnionFindArray implements UF {
    private int[] id;
    public UnionFindArray(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    /**
     * 查看并查集中元素的个数
     *
     * @return 返回元素的个数
     */
    @Override
    public int getSize() {
        return id.length;
    }
    private int find(int p){
        if(p < 0 || p>= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查询两个元素是否相连
     *
     * @param p 需要查找的第一个元素
     * @param q 需要查找的第二个元素
     * @return 返回是否相连
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将两个元素相连接
     *
     * @param p 需要连接的第一个元素
     * @param q 需要连接的第二个元素
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == qId){
                id[i] = qId;
            }
        }
    }
}

/**
 * Date: 2020/2/23 4:39 下午
 *
 * @author 3zZ.
 * 基于rank来union
 * 同时使用了路径压缩
 */
public class UnionFindForest implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFindForest(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查看并查集中元素的个数
     *
     * @return 返回元素的个数
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >=parent.length){
            throw new IllegalArgumentException("P is out of bound.");
        }
        if (p != parent[p]) {
            // 路径压缩
            // 第一版
            // parent[p] = parent[parent[p]];
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
            rank[qRoot] += rank[pRoot];
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}

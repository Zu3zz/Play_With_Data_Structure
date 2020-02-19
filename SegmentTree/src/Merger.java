/**
 * Date: 2020/2/19 4:45 下午
 *
 * @author 3zZ.
 */
public interface Merger<E> {
    /**
     * 将a，b按照需要的方式进行组装融合
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}

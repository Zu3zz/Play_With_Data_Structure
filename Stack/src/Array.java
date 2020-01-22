/**
 * Date: 2020/1/22 2:30 下午
 *
 * @author 3zZ.
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e 需要添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e 需要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素 e
     *
     * @param index 位置下标
     * @param e     需要插入的新元素
     */
    public void add(int index, E e) {
        if (size == data.length) {
            // throw new IllegalArgumentException("List is already full. Add list failed");
            resize((int) (1.5 * data.length));
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index > 0 && index < size. Add list failed");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取相应位置的元素
     *
     * @param index 需要获取元素的下标
     * @return 返回元素值
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index > 0 && index < size. Add list failed");
        }
        return data[index];
    }

    /**
     * 返回最后一位的元素
     *
     * @return 最后一位元素的值
     */
    public E getFirst() {
        return get(size - 1);
    }

    /**
     * 返回第一个元素的值
     *
     * @return 第一位元素的值
     */
    public E getLast() {
        return get(0);
    }

    /**
     * 修改相应位置的元素
     *
     * @param index 需要修改元素的下标
     * @param e     修改的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index > 0 && index < size. Add list failed");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引
     *
     * @param e 需要查找的元素
     * @return 存在则返回相应的位置 不存在则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return 返回第一个元素的值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     *
     * @return 返回最后一个元素的值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素
     *
     * @param index 需要删除元素的下标
     * @return 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index > 0 && index < size. Add list failed");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d, The capacity is %d\n", size, data.length));
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}


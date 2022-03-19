package collection;

import java.util.Objects;

class MyArrayList {
    private Object[] elements = null;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[128];
        // TODO
    }
    public boolean add(Object o) {
        this.elements[this.size++] = o;
        // TODO
        return true;
    }
    public Object get(int index) {
        checkIndex(index, this.size);
        // TODO
        return this.elements[index];
    }
    void checkIndex(int index, int length) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index +" + 에 위치하는 요소가 없어요");
    }
    public int size() {
        // TODO
        return this.size;
    }
    public boolean isEmpty() {
        // TODO
        return this.size == 0;
    }
    public int indexOf(Object o) {
        // TODO
        for (int i = 0; i < this.size; i++) {
            if(Objects.equals(o,elements[i])){
                return i;
            }
        }
        return -1;
    }
    public void clear() {
        this.elements = new Object[128];
        this.size = 0;
    }
    public Object remove(int index) {
        // TODO
        this.elements[index] = null;
        for (int i = index; i < size-1; i++) {
            this.elements[i] = this.elements[i++];
        }
        this.elements[size] = null;
        size--;
        return this.elements[index];
    }
}
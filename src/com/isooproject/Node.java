package com.isooproject;

// T: Type E: Element
public class Node<T> {
//    private Object[] data = new Object[10];
//    T get(int idx) {
//        return (T) data[idx];
//    }
//    void set(T data) {
//        this.data[9] = data;
//    }

    private T[] data;
    private int lastIdx = 0;

    public Node() {
        this.data = (T[]) new Object[10];
    }

    public T get(int idx) {
        return data[idx];
    }

    public void set(T datum) {
        data[lastIdx] = datum;
    }

    public static void main(String[] args) {
        // 앞에 Integer로 명시해놨기 때문에 뒤엔 Integer라는 단어는 생략됨
        Node<Integer> node = new Node<>();
    }
}

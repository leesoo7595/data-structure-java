package com.isooproject;

import java.util.NoSuchElementException;

// T: Type, E: Element, K: Key, V: Value
public class MyArrayList<E> {
    // 하나의 배열을 만들때, DEFAULT_SIZE로 100을 둔다.
    private static final int DEFAULT_SIZE = 100;

    // 내부에 배열을 가지고 있다.
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size) {
        elements = new Object[size];
    }

    // 데이터를 추가하는 함수
    public void add(E element) {
        ensuringSize();
        // size 다음으로 추가됨 -> end도 증가해줘야함!
        elements[size++] = element;
    }

    // 데이터를 가져오는 함수
    public E get(int index) {
        // 사이즈와 같거나 큰 값인 index를 조회하면 에러를 낸다(비어잇는 값일 수 있음)
        if (index >= size) throw new NoSuchElementException();
        return (E) elements[index];
    }

    // size를 늘려주는 함수
    private void ensuringSize() {
        // size가 elements.length보다 작으면 그냥 반환
        if (size < elements.length) return;

        // tempSize를 두 배로 늘릴 때, Integer의 max_value(21억개)를 넘어서는지 체크
        int tempSize = elements.length * 2 < Integer.MAX_VALUE ? elements.length * 2 : Integer.MAX_VALUE;
        Object[] temp = new Object[tempSize];
        // 옮겨주는 작업 필요
        // elements를 0번째 배열부터 temp로 0번째부터 elements.length까지 카피한다.
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }


}

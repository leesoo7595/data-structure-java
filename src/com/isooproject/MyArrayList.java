package com.isooproject;

import java.util.NoSuchElementException;

// T: Type, E: Element, K: Key, V: Value
public class MyArrayList<E> {
    // 하나의 배열을 만들때, DEFAULT_SIZE로 64 둔다.
    private static final int DEFAULT_SIZE = 64;

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
        insert(size, element);
    }

    // 데이터를 가져오는 함수
    public E get(int index) {
        // 사이즈와 같거나 큰 값인 index를 조회하면 에러를 낸다(비어잇는 값일 수 있음)
        if (index >= size) throw new NoSuchElementException();
        return (E) elements[index];
    }

    // 어느 부분에 데이터를 삽입하는 함수
    public void insert(int index, E element) {
        // 사이즈보다 큰 값인 index에 추가하려할 때 에러를 낸다
        if (index > size) throw new IndexOutOfBoundsException();

        // 중간에 index가 추가될 때, 그 뒷 값들은 다 한 칸 씩 미루어주어야함!
        // 값이 추가되었을 때, 사이즈가 증가되어야하는지 체크
        ensuringSize();
        // right shift;
        // index번째 이전까지 그냥 복사
        System.arraycopy(elements, 0, elements, 0, index);
        // index번째 이후로는 나머지 + 1 하고 복사
        System.arraycopy(elements, index, elements, index + 1, size - index);
        // 비어있게 된 index번째 자리에 element(새로운 요소)를 넣어준다.
        elements[index] = element;
        size++;
    }

    // 데이터를 삭제하는 함수
    public E delete(int index) {
        // index가 있는지 없는지 get함수로 확인
        E result = get(index);
        // 사이즈 줄일 필요있는지 체크
        ensuringSize();
        // index번째 이전까지 그냥 복사
        System.arraycopy(elements, 0, elements, 0, index);
        // index번째를 지우고!(--size) 나서 나머지 한 칸씩 left shift
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        return result;
    }

    // size를 늘려주는 함수
    private void ensuringSize() {
        // size가 elements.length와 같거나 크면 사이즈 늘리기
        if (size >= elements.length) {
            // tempSize를 두 배로 늘릴 때, Integer의 max_value(21억개)를 넘어서는지 체크
            int tempSize = elements.length * 2 < Integer.MAX_VALUE ? elements.length * 2 : Integer.MAX_VALUE;
            Object[] temp = new Object[tempSize];
            // 옮겨주는 작업 필요
            // elements를 0번째 배열부터 temp로 0번째부터 elements.length까지 카피한다.
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        } else if (size - 1 <= elements.length / 4) {
            Object[] temp = new Object[elements.length / 2];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = temp;
        }
    }

}

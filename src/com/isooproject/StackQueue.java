package com.isooproject;

public class StackQueue {

    // 맨 위에만 추가해주고 가져간다.
    // LIFO : 마지막에 들어온 것이 먼저 나간다.
    static class Stack<E> {
        private E[] elements;
        // 아무것도 없을 때 pop을 시키면 에러를 내기 위해서
        private int top = -1;

        public Stack(int size) {
            elements = (E[]) new Object[size];
        }

        public void push(E element) {
            // 사이즈가 elements.length보다 클 경우
            if (top + 1 >= elements.length) {
                throw new IndexOutOfBoundsException();
            }
            elements[++top] = element;
        }

        public E pop() {
            if (top < 0) {
                throw new IndexOutOfBoundsException();
            }
            return elements[top--];
        }
    }

    

}

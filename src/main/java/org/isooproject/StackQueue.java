package org.isooproject;

import java.util.NoSuchElementException;

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

    // FIFO : 선입선출, 먼저 온 사람이 먼저 나간다.
    static class  Queue<E> {
        private E[] elements;
        // head : deQueue를 하면 나갈 element
        // tail : enQueue를 하면 들어올 element
        private int head, tail, size;

        public Queue(int size) {
            elements = (E[]) new Object[size];
        }

        public E deQueue() {
            if (size == 0) {
                throw new IndexOutOfBoundsException();
            }
            // head가 tail보다 클 경우 -> 자료가 없다
//            if (head > tail)
//                throw new IndexOutOfBoundsException();
            size--;
            return elements[head++];

        }

        public void enQueue(E element) {
            // 사이즈를 넘어섰을 때
            if(tail + 1 >= elements.length)
                throw new IndexOutOfBoundsException();
            
            // size가 가득 찼을 때
            if (size == elements.length) throw new IndexOutOfBoundsException();
            // 비어있는 곳에 tail을 붙이려고 나머지 연산을 한다.
            tail = ++tail % elements.length;
            // 증가시킨 tail값에 element를 넣어준다.
            elements[++tail] = element;
        }
    }

}

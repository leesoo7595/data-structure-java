package com.isooproject;

public class MyCircularLinkedList<E> {
    Node<E> head;
    int size = 0;

    public MyCircularLinkedList() {
        head = new Node<>(null);
        // head.before = tail
        head.before = head;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        // newNode의 전은 head의 전(tail) -> newNode.before = tail;
        newNode.before = head.before;
        // head의 전의 다음은 newNode -> tail.next = newNode;
        head.before.next = newNode;
        // head의 전은 newNode -> tail = newNode;
        head.before = newNode;
        // newNode의 다음은 head -> newNode(tail).next = head;
        newNode.next = head;
        // 사이즈 1 증가
        size++;
    }

    static class Node<E> {
        private Node<E> before;
        private Node<E> next;
        private E element;

        public Node(E element) {
            this.element = element;
        }

        public Node<E> getBefore() {
            return before;
        }

        public void setBefore(Node<E> before) {
            this.before = before;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }
}

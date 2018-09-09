package com.isooproject;

public class MyLinkedList<E> {
    // head가 tail을 가리켜야함 (연결시켜야함)
    private Node head = new Node<>(null);
    private Node tail= head;
    private int size = 0;

    // 리누스 토발즈 : 특수한 케이스를 최소화하라.
    // Tail 뒤에 추가하기
    public void addTail(E element) {
        // 아래서 constructor로 강제성 부여
        Node<E> newNode = new Node<>(element);
        // tail 다음으로 newNode를 붙이기
        tail.setNext(newNode);
        // tail을 newNode로
        tail = newNode;
        // size 1증가
        size++;
    }

    // Head 뒤에 추가하기
    public void addHead(E element) {
        Node<E> newNode = new Node<>(element);
        // 임시로 head 옆에 있는 element를 가져와서 next로 지정
        Node<E> next = head.getNext();
        // 그 next를 newNode.setNext로 지정
        newNode.setNext(next);
        // head의 setNext는 newNode로 지정
        head.setNext(newNode);
        // 사이즈 1 증가
        size++;
    }

    static class Node<E> {
        private E element;
        private Node next;

        // 무조건 element 지정하도록 설정
        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

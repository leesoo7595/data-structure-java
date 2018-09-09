package com.isooproject;

public class BST<K extends Comparable, V> {
    private Node<K, V> root;

    // key값 찾아서 value 반환
    public V search(K key) {
        return search(root, key);
    }
    // root부터 재귀적으로 찾게 하기위해 private함수를 만듬
    // 한 노드를 기준으로 자신의 하위의 key를 가지고 찾도록 한다
    private V search(Node<K, V> node, K key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare == 0) return node.value;
        else if (compare < 0) return search(node.left, key);
        else if (compare > 0) return search(node.right, key);
        return null;
    }

    // K, V 삽입하기(어떤 새로운 value를 어떤 key에 넣을거야?)
    public void insert(K key, V value) {
        root = insert(root, new Node<K, V>(key, value));
    }
    // root부터 재귀적으로 newNode를 넣을 key를 찾아서 value를 넣을건지를 정함
    // 어떤 노드(root)를 가지고 어떤 key에 value를 넣을 건지
    private Node insert(Node<K, V> node, Node<K, V> newNode) {
        if (node == null) return newNode;
        int compare = newNode.key.compareTo(node.key);
        if (compare == 0) {
            node.value = newNode.value;
        } else if (compare < 0) {
            node.right = insert(node.right, newNode);
        }
        return node;
    }

    // 최소값 구하기
    public V min() {
        return min(root).value;
    }

    // 어떤 노드를 가지고 재귀적으로 왼쪽만 체크(왼쪽이 오른쪽 value보다 작다)
    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    // 생성자
    class Node<K extends Comparable, V> {
        K key;
        V value;
        Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

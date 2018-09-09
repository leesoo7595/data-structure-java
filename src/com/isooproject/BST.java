package com.isooproject;

public class BST<K extends Comparable, V> {
    private Node<K, V> root;

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node<K, V> node, K key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare == 0) return node.value;
        else if (compare < 0) return search(node.left, key);
        else if (compare > 0) return search(node.right, key);
        return null;
    }

    public void insert(K key, V value) {
        root = insert(root, new Node<K, V>(key, value));
    }

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

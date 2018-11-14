package org.isooproject;

public class Tree {

    Node root;
    static {

    }
    {
        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
    }
    // 어떻게 순회하는가?
    //    0
    //  1   2
    // 3 4

    // 전위
    public void pre() {pre(root);}

    private void pre(Node node) {
        if (node == null) return;
        // 자기자신을 먼저보고(root)
        visit(node);
        // 왼쪽을 visit하고 (재귀적)
        // 순회라는 것은 stack구조를 이용하게 된다
        // 메소드가 메모리stack에 쌓여있기 때문에
        pre(node.left);
        // 오른쪽을 visit하라 (재귀적)
        pre(node.right);
    }

    // 중위
    public void mid() {mid(root);}

    private void mid(Node node) {
        if (node == null) return;
        mid(node.left);
        visit(node);
        mid(node.right);
    }

    // 후위
    public void post() {post(root);}

    private void post(Node node) {
        if (node == null) return;
        post(node.left);
        post(node.right);
        visit(node);
    }

    void visit(Node node) {
        System.out.println(node.value);
    }

    class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}

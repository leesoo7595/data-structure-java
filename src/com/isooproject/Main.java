package com.isooproject;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree tree = new Tree();
        tree.pre();
        System.out.println("=========");
        tree.mid();
        System.out.println("=========");
        tree.post();
        System.out.println("=========");
    }
}

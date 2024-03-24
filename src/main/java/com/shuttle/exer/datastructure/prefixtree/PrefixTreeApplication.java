package com.shuttle.exer.datastructure.prefixtree;

public class PrefixTreeApplication {
    public static void main(String[] args) {
        PrefixTree tree = new PrefixTree();
        tree.addElement("apple");
        tree.addElement("banana");
        tree.addElement("app");
        tree.addElement("bat");
        tree.addElement("ball");
        tree.addElement("cat");
        tree.printTree();
        /**
         * app
         * apple
         * ball
         * banana
         * bat
         * cat
         */
    }

}

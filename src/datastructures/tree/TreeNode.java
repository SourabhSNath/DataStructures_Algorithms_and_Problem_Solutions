package datastructures.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class TreeNode {
    TreeNode left;
    TreeNode right;

    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int val) {
        if (val <= data) {
            if (left == null) {
                left = new TreeNode(val);
            } else {
                left.insert(val); // Recursive
            }
        } else {
            if (right == null) {
                right = new TreeNode(val);
            } else {
                right.insert(val);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            System.out.println("left: ");
            left.printInOrder();
        }

        System.out.println(data);

        if (right != null) {
            System.out.println("right: ");
            right.printInOrder();
        }
    }

}

final class BinaryTreeImplementation {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.insert(2);
        node.insert(5);
        node.insert(1);
        node.insert(3);
        node.printInOrder();
    }

}
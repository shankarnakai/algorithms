package datastructures.tree.binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {}

    public int get(int index) {
        return 0;
    }

    public Optional<Node> getNode(int index) {
        return Optional.empty();
    }

    public void add(int value) {
        if(this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node node = this.root;
        Node prev = this.root;
        while(node != null) {
            prev = node;
            if(value > node.value) {
                node = node.right;
                continue;
            }
            node = node.left;
        }

        if(value > prev.value) {
            prev.right = new Node(value);
        } else {
            prev.left = new Node(value);
        }
    }

    public Optional<Node> remove(int value) {
        if(root == null) return Optional.empty();

        Node sentinel = new Node(0);
        sentinel.right = root;
        sentinel.left = root;

        Node node = root;
        Node parent = sentinel;
        while(node != null && node.value != value) {
            parent = node;
            if(value > node.value) {
                node = node.right;
                continue;
            }
            node = node.left;
        }

        if(node == null) return Optional.empty();
        if(node.left == null && node.right == null) {
            if(node == root) {
                root = null;
            } else if(parent.right == node) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            return Optional.of(node);
        }

        Node left = node.left;
        Node right = node.right;
        Node minMax = node;
        Node prev = node;
        while(left != null || right != null) {
            if(left != null) {
                prev = minMax;
                minMax = left;
                left = left.right;
            }

            if(right != null) {
                prev = minMax;
                minMax = right;
                right = right.left;
            }
        }

        minMax.right = node.right;
        minMax.left = node.left;

        parent.right =  parent.right == node ? minMax: parent.right;
        parent.left =  parent.left == node ? minMax: parent.left;

        if(node == root) {
            root = minMax;
        } else if(parent.right == node) {
            parent.right = minMax;
        } else {
            parent.left = minMax;
        }

        if(prev.right == minMax) {
            prev.right = null;
        } else {
            prev.left = null;
        }

        node.right = null;
        node.left = null;
        return Optional.of(node);
    }

    public Optional<Node> search(int value) {
        return Optional.empty();
    }

    public List<Integer> toList() {
        if (root == null) return new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Node left = root;
        while(left != null) {
            stack.push(left);
            left = left.left;
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            System.out.println("Here");
            Node node = stack.pop();
            result.add(node.value);

            if(node.right != null) {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}


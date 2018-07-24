package com.javarush.task.task36.task3604;

public class RedBlackTree {
    private static final Node EMPTY = new Node(0); // special empty node

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }

    protected Node current; // Текущий узел
    private Node parent; // Родительский узел текущего узла
    private Node grand;  // ???
    private Node great;  // ???
    private Node header; // ???

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return header.left == EMPTY && header.right == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) {
        // Сброс текущего элемента
        current = grand = parent = header;

        // ???
        EMPTY.element = item;

        // Пока значение текущего элемента не равно нужному значению
        while (current.element != item) {
            // Черт его знает что происходит
            great = grand;
            grand = parent;
            parent = current;

            // Это понятно, если значение текущего элемента меньше, чем item, то двигаемся в правое поддерево, иначе в левое (так как слева всегда меньшее значение, а справа большее)
            current = item > current.element ? current.right : current.left;

            if (current.left.color == Color.RED && current.right.color == Color.RED) {
                reorient(item);
            }
        }

        // Да что это вообще значит??
        if (current != EMPTY) {
            return;
        }

        // А чему current до этого был равен? Что такое header вообще?
        current = new Node(item, EMPTY, EMPTY);

        // Тут все понятно: если наше значение меньше текущего значения вершины, то вставляем его влево, иначе вправо.
        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item);
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}

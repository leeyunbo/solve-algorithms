package datastructure;

public class LinkedListApplication {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.print();
        linkedList.addFirst(4);
        linkedList.print();
        linkedList.addFirst(5);
        linkedList.print();
        linkedList.addLast(10);
        linkedList.print();
        linkedList.remove(4);
        linkedList.print();
        linkedList.remove(4);
        linkedList.print();
        linkedList.remove(4);
        linkedList.print();
        linkedList.print();
    }
}

class Node {
    private Node left;
    private Node right;
    private final int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = tail = node;
        }
        else {
            node.setRight(head);
            head.setLeft(node);
            head = node;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = tail = node;
        }
        else {
            tail.setRight(node);
            node.setLeft(tail);
            tail = node;
        }
    }

    public void remove(int data) {
        Node node = head;
        while(node != null) {
            if(node.getData() == data) {
                if(node == head) {
                    if(node.getRight() != null) {
                        head = node.getRight();
                        node.getRight().setLeft(null);
                    }
                    else {
                        head = tail = null;
                    }
                }
                else if(node == tail){
                    tail = node.getLeft();
                    node.getLeft().setRight(null);
                }
                else {
                    node.getLeft().setRight(node.getRight());
                    node.getRight().setLeft(node.getLeft());
                }

                node = null;
                break;
            }

            node = node.getRight();
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.getData() + "->");
            node = node.getRight();
        }
        System.out.println();
    }

    public void clear() {
        head = null;
        tail = null;
    }
}
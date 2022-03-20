package datastructure;

public class BinarySearchTree {
    public static void main(String[] args) {

    }
}


class BST {
    TreeNode root;

    TreeNode search(int data, TreeNode currentNode) {
        if(currentNode == null) return null;

        if(currentNode.data == data) return currentNode;
        else if(currentNode.data > data) return search(data, currentNode.left);
        else return search(data, currentNode.right);
    }

    void insert(int data, TreeNode currentNode) {
        if(currentNode == null) currentNode = new TreeNode(data);

        if(currentNode.data == data) {
            System.out.println("데이터 중복");
        }
        else if(currentNode.data < data) {
            insert(data, currentNode.right);
        }
        else {
            insert(data, currentNode.left);
        }
    }

    void inorder(TreeNode currentNode) {
        if(currentNode != null) {
            inorder(currentNode.left);
            System.out.print(currentNode.data);
            inorder(currentNode.right);
        }
    }

    void preorder(TreeNode currentNode) {
        if(currentNode != null) {
            System.out.print(currentNode.data);
            inorder(currentNode.left);
            inorder(currentNode.right);
        }
    }

    void postorder(TreeNode currentNode) {
        if(currentNode != null) {
            inorder(currentNode.left);
            inorder(currentNode.right);
            System.out.print(currentNode.data);
        }
    }

    void delete(int data, TreeNode currentNode, TreeNode parentNode) {
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }
}

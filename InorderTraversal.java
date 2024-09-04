/*Problem Statement: Inorder Traversal of a Binary Tree
Objective
Given the root node of a binary tree, you need to print the values of the nodes in inorder traversal as a single line of space-separated values.

Inorder Traversal
Inorder traversal is a depth-first traversal method where nodes are visited in the following order:

Left Subtree: Visit all nodes in the left subtree.
Root Node: Visit the root node.
Right Subtree: Visit all nodes in the right subtree.

Input
root: A Node object representing the root of the binary tree.

Output
Print the values of the nodes in inorder traversal in a single line of space-separated values.

Constraints
The tree will contain unique integer values.
The binary tree is not necessarily balanced.
*/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class InorderTraversal {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }	
}

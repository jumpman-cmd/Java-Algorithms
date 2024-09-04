/*Problem Statement: Binary Tree Postorder Traversal
Objective:
Complete the function postOrder in the editor below, which takes a parameter: a pointer to the root of a binary tree. It must print the values in the tree's postorder traversal as a single line of space-separated values.

Input Format:
Our test code passes the root node of a binary tree to the postOrder function.

Output Format:
Print the tree's postorder traversal as a single line of space-separated values.
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

class PostOrder {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void postOrder(Node root) 
    {
        if(root == null)
        {
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        
        System.out.print(root.data + " ");
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
        postOrder(root);
    }	
}
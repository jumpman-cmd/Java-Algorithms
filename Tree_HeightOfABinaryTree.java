/*
Problem Statement: Tree: Height of a Binary Tree
Given the root node of a binary tree, you are required to compute the height of the tree. The height of a binary tree is defined as the number of edges on the longest path from the root node to a leaf node. A leaf is a node with no children.

Input Format:
The input consists of a number of integers. The first integer, n, indicates the number of nodes in the tree.
The subsequent n integers represent the values of the nodes, which are inserted into the tree following the rules of a binary search tree.

Output Format:
The output should be a single integer representing the height of the binary tree.

Constraints:
The number of nodes in the tree can range from 1 to 1000.
The value of each node will be a positive integer.
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

class Tree_HeightOfABinaryTree {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) 
    {
      	// Write your code here.
          if(root == null)
          {
              return -1;
              // break;
          }
          
          int leftHeight = height(root.left);
          int rightHeight = height(root.right);
          
          return Math.max(leftHeight, rightHeight) + 1;
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
        int height = height(root);
        System.out.println(height);
    }	
}

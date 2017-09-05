import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Btree_LCA {


	public static void main(String[] args) {

		//Btree establish
		Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
 
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

		System.out.println("Node x and y is: " + findLCA(root, root.left, null).value);
         
        //System.out.println("Node 3 and null is: " + findLCA(root, root.right.right.right, null).value);
         			
		
		
	}
	
/**
     * Recursive approach to find the Lowest Common Ancestor
     * @param root
     * @param a - first Node
     * @param b - second Node
     * @return Node that is lowest common ancestor of both a and b
     */
    public static Node findLCA(Node root, Node a, Node b) {
 
        Node left = null;
        Node right = null;
 
        if (root == null) {
            return null;
        }
          
        /**
         * If Node a or Node b is also the root, then the root itself is lowest common ancestor
         */
        if (root == a || root == b) {
            return root;
        }
 
        left = findLCA(root.left, a, b);
        right = findLCA(root.right, a, b);
 
        /**
         * If Node a and Node b lie in the left, their Lowest Common Ancestor is in the left.
         * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
         *
         * Otherwise, root is the Lowest common ancestor.
         */
        if (left != null && right != null) {
            return root;
        }
 
        return (left != null) ? left : right;
    }

	/**
	 * Binary Tree representation.
	 */
	static class Node {
		Node left;
		Node right;
		int value;
		 
		public Node(int value) {
			left = null;
			right = null;
			this.value = value;
		}
	}	
	
	

}
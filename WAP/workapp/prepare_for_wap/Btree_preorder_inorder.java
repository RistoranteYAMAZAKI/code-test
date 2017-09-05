import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Btree_preorder_inorder {


	public static void main(String[] args) {

		//Btree establish
		Node root = new Node("A");
        root.left = new Node("B");
        root.right = new Node("C");
        root.left.left = new Node("D");
        root.left.right = new Node("F");
		root.left.right.right = new Node("H");
        root.right.right = new Node("G");
		root.left.left.left = new Node("q");
		root.left.left.right = new Node("z");
		
		//Preorder(root);
		//Inorder(root);
		Postorder(root);
		
	}
	
	// root > left > right
    public static Node Preorder(Node root) {
 
        Node left = null;
        Node right = null;
		
		System.out.println(root.value);
		if(root.left != null){
			Preorder(root.left);
		}
		
		if(root.right != null){
			Preorder(root.right);
		}		
		
		if(root.left == null && root.right == null){
			return null;
		}
		
		return null;
    }
	
	// dep_left > root > dep_right
	// rule is strange...
	// have left then print root, no left then first print right then root
    public static Node Inorder(Node root) {
 
        Node left = null;
        Node right = null;
		
		if(root.left == null && root.right == null){
			System.out.println(root.value);
			return null;
		}		
		
		
		if(root.left != null){
			Inorder(root.left);
		}
		if(root.left != null){
			System.out.println(root.value);
		}		
		
		
		if(root.right != null){
			
			Inorder(root.right);
		}
		if(root.left == null && root.right != null){
			System.out.println(root.value);
		}
				
		return null;
    }	
	
	// dep_left > dep_right > root
    public static Node Postorder(Node root) {
 
        Node left = null;
        Node right = null;
		
		if(root.left == null && root.right == null){
			System.out.println(root.value);
			return null;
		}		
		
		
		if(root.left != null){
			Postorder(root.left);
		}		
				
		if(root.right != null){
			Postorder(root.right);
		}
		
		System.out.println(root.value);
		
				
		return null;
    }	
	
	/**
	 * Binary Tree representation.
	 */
	static class Node {
		Node left;
		Node right;
		String value;
		 
		public Node(String value) {
			left = null;
			right = null;
			this.value = value;
		}
	}	
	
	

}
import java.util.*;

public class list_to_btree {
	
	public static int index = 0;
	
	public static List<Integer> inorder_travesal(Treenode tree) {
		
		List<Integer> list = new ArrayList<Integer>();
		Stack<Treenode> stack = new Stack<Treenode>();
		
		Treenode cur = tree;
		
		while(cur != null || stack.size() != 0) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.value);
			cur = cur.right;
		}
		
		return list;
	
		
	}
	
	public static class Treenode {
		Treenode left;
		Treenode right;
		int value;
		Treenode(int value) {
			left = null;
			right = null;
			this.value = value;
		}
	}
	
    public static Treenode to_Btree(int[] nums) {
		
		//System.out.println(index);
		if((index > nums.length-1) || (nums[index] == -1)) {
			return null;
		}
		Treenode tree = new Treenode(nums[index]);
		
		//tree.value = nums[index];
		index++;
		tree.left = to_Btree(nums);
		index++;
		tree.right = to_Btree(nums);
		
		return tree;
		
    }

	
	public static void main(String[] args){
		
		int[] nums = {1,2,7,-1,2,4,5,-1};
		Treenode tree;
		tree = to_Btree(nums);
		
		List<Integer> list = new ArrayList<Integer>();
		list = inorder_travesal(tree);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		/*
		if(tree.right == null) {
			System.out.println("aaa");
		}
		*/
		//System.out.println(tree.value);
	}
  

}
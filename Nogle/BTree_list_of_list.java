import java.util.*;

public class BTree_list_of_list {

	public void levelOrderBottom(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		System.out.println(wrapList.size() + "\n");
		levelMaker(wrapList, root, 0);
		
        for(int i = 0; i < wrapList.size(); i++) {
            System.out.println(wrapList.get(i));
        }		
	}
	
	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if(root == null) return;
		if(level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level+1);
		levelMaker(list, root.right, level+1);
		System.out.println(list.size() + " " + level + " " + root.value + "\n");
		list.get(list.size()-level-1).add(root.value);
	}
		
	public static void main(String[] args) {
		BTree_list_of_list B = new BTree_list_of_list();
		TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);	
		B.levelOrderBottom(root);
		
	}
	
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;
		
		public TreeNode(int value) {
			right = null;
			left = null;
			this.value = value;
		}
	}
}
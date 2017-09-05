import java.util.*;

public class wiggle_sort {
	
	public void quick_sort(int[] nums, int left, int right) {
		
		if(right > left) {
			int i = left, j = right, tmp; 
			int v = nums[right];
			
			do{
				while(nums[i] < v) {
					i++;
				}
				while(nums[j] > v) {
					j--;
				}
				
				if(i <= j) {
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
					i++;
					j--;
				}
			}while(i <= j);
			
			if(left < j)	quick_sort(nums, left, j);
			
			if(i < right)	quick_sort(nums, i, right);
		}
		

	} 
	
	public void wiggle(int[] nums) {
		/*
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
		*/
		quick_sort(nums, 0, nums.length-1);
		/*
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
		*/
		int tmp;
		for(int i = 1; i < nums.length; i=i+2) {
			if(i >= nums.length-1)
				break;
			
			tmp = nums[i];
			nums[i] = nums[i+1];
			nums[i+1] = tmp;
		}
		
		
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		wiggle_sort W = new wiggle_sort();
		
		int[] nums = {1,5,2,6,8,2,3,9};
		W.wiggle(nums);
	}
}
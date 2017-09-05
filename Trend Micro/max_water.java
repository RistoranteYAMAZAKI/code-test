import java.util.*;

public class max_water {
	
	public void find_max(int[] arr) {
		
		int l = arr.length;
		int max = 0, volumn = 0; 
		
		for(int i = 0; i < l; i++) {
			for(int j = i+1; j < l; j++) {
				if(arr[i] > arr[j]){
					volumn = arr[j]*(j-i);
				}
				else {
					volumn = arr[i]*(j-i);
				}
				//System.out.print(max + "\n");
				if(volumn > max) {
					max = volumn;
				}				
			}
			
		}
		System.out.print(max + "\n");
		
	}

	public void maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right])
					* (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		System.out.print(maxArea + "\n");
	}
	
	public static void main(String[] args) {
		
		max_water mw = new max_water();
		int[] array = {3,6,2,7,11,5,8,9,15,2};
		mw.find_max(array);
		mw.maxArea(array);
		
	}
	
}
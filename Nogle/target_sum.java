import java.util.*;

public class target_sum {
	
	public void find(int[] nums, int S) {
		int sum = 0, sub_point = 0, check = 0, n_ways = 0;
		
		while(check != nums.length) {
			check++;
			for(int i = 0; i < nums.length; i++) {
				if(sub_point == i) {
					sum = sum + nums[i]*(-1);
				}
				else {
					sum = sum + nums[i];
				}
			}
			if(S == sum) {
				n_ways++;
			}
			sum = 0;
			sub_point++;
		}
		System.out.print(n_ways + "\n");
	
	}
	
	public static void main(String[] args) {
		
		target_sum ts = new target_sum();
		int[] nums = {2, 2, 3, 6, 4};
		int S = 13;
		ts.find(nums, S);
		
	}
}
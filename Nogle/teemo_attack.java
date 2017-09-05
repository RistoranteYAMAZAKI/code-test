import java.util.*;

public class teemo_attack {
	
	public int teemo(int[] arr, int time) {
		int check = 0, total = 0;
		for(int i = 0; i < arr.length; i++) {
			if(check == 0) {
				check = arr[i] + time;
			}
			else {
				if(check > arr[i]) {
					check = arr[i] + time;
					total = total + (arr[i]-arr[i-1]);					
				}
				else {
					check = arr[i] + time;
					total = total + time;
				}
				if(i == (arr.length - 1)) {
					total = total + time;
				}				
				
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		teemo_attack t = new teemo_attack();
		int[] nums = {1,2,4,6,7};
		int time = 3;
		System.out.print(t.teemo(nums, time) + "\n");
		
	}
}
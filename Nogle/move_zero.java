import java.util.*;

public class move_zero {
	
	public int[] movement(int[] num) {
		
		int[] arr = new int[num.length];
		int count = 0;
		for(int i = 0; i < num.length; i++) {
			if(num[i] != 0) {
				arr[count] = num[i];
				count++;
			}
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		
		int[] num = {0, 1, 0, 3, 12};
		move_zero move = new move_zero();
		num = move.movement(num);
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.print("\n");
	}
}
import java.util.*;

public class perfect_square {
	
	public static void calculate(int number, int square) {
		
		int tmp1 = 0, tmp2 = 0, min = 100, count = 2;
		int[] square_arr = new int[square]; 
		
		
		for(int i = 1; i <= square; i++) {
			square_arr[i-1] = i*i;
			if(square_arr[i-1] == number){
				System.out.print("1\n");
				return;
			}
		}
		
		tmp2 = square_arr[square-1];
		for(int i = square-1; i >= 0; i--) {
			tmp2 = square_arr[i];
			for(int j = i; j >= 0; j--) {
				
				tmp1 = tmp2 + square_arr[j];
				while(tmp1 <= number) {
					if(tmp1 == number) {
						if(count <= min) {
							min = count;
						}
						tmp1 = 0;
						tmp2 = square_arr[i];
						break;
						//System.out.print(count + "\n");
					}
					else {
						tmp2 = tmp1;
						tmp1 = tmp1 + square_arr[j];
						count++;
					}
					
				}
				tmp1 = 0;

			}
			count = 2;
			tmp1 = 0;
		}
		
		System.out.print(min + "\n");
		
	}
	
	
	public static void main(String[] args) {
		
		int number = 12;
		int square = (int) Math.sqrt(12);
		calculate(number, square);
		
	}
	
}
import java.util.*;

public class sell_stock {
	
	public void max_profit(int[] input) {
		
		int max = 0;
		for(int i = 0; i < input.length; i++) {
			
			for(int j = i+1; j < input.length; j++) {
				
				if(input[j] - input[i] > max) {
					max = input[j] - input[i];
				}
				
			}
			
		}
		
		System.out.print("Max profit : " + max + "\n");
	}
	
	public static void main(String[] args) {
		
		sell_stock sell = new sell_stock();
		int[] input = {7, 6, 4, 3, 1};
		sell.max_profit(input);
	}
	
}
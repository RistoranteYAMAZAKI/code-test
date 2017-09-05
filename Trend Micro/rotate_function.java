import java.util.*;

public class rotate_function {
	
	public void rotate(ArrayList<Integer> input) {
		
		int max = 0, tmp = 0, check = 0;
		int l = input.size();
		
		while(check != l) {

			for(int i = 0; i < l; i++) {
				
				tmp = tmp + input.get(i)*i; 
				
			}
			
			System.out.print("now is : " + tmp + "\n");
			
			if(tmp > max){
				max = tmp;
			}
			
			input.add(input.get(0));
			input.remove(0);
			tmp = 0;
			check++;
		}
		
		
		System.out.print("Max profit : " + max + "\n");
	}
	
	public static void main(String[] args) {
		
		rotate_function r = new rotate_function();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(3);
		input.add(2);
		input.add(6);
		r.rotate(input);
	}
	
}
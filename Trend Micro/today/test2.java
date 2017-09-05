import java.util.*;

public class test2 {
	
    public static int solution(String S) {
        // write your code in Java SE 8
		Stack<Integer> nums = new Stack<Integer>();
		String[] split = S.split(" ");
		int tmp1 = 0, tmp2 = 0;
		
		for(int i = 0; i < split.length; i++) {
			if(split[i].equals("POP")) {
				if(nums.size() == 0) {
					return -1;
				}				
				nums.pop();
			}
			else if(split[i].equals("DUP")) {
				if(nums.size() == 0) {
					return -1;
				}					
				nums.push(nums.peek());			
			}
			else if(split[i].equals("+")) {
				if(nums.size() < 2) {
					return -1;
				}				
				tmp1 = nums.pop();
				tmp2 = nums.pop();
				nums.push(tmp1+tmp2);
			}
			else if(split[i].equals("-")) {
				if(nums.size() < 2) {
					return -1;
				}					
				tmp1 = nums.pop();
				tmp2 = nums.pop();
				if((tmp1-tmp2) < 0) {
					return -1;
				}
				nums.push(tmp1-tmp2);				
			}
			else {
				nums.push(Integer.parseInt(split[i]));
			}			
			
		}
		
		if(nums.empty()) {
			return -1;
		}
		else {
			return nums.peek();
		}
    }
	
	public static void main(String[] args) {
		
		String s  = "POP 3 4 5 - -";
		int num = solution(s);
		System.out.print(num + "\n");
	}
}

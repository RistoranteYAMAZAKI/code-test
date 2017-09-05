import java.util.*;

public class test {
	
    public static int solution(String S) {
        // write your code in Java SE 8
		int l = S.length();
		int count = 0, max = 0, check = 0;
		for(int i = 0; i < l; i++) {
			if(Character.isUpperCase(S.charAt(i))) {
				count++;
				check = 1;
				//System.out.print(S.charAt(i)+"\n");
			}
			else if(Character.isDigit(S.charAt(i))) {
				if(count > max && check == 1) {
					max = count;
				}
				count = 0;
				check = 0;
				//System.out.print(max + " " + S.charAt(i)+"\n");
				continue;
			}
			else {
				//System.out.print(S.charAt(i)+"\n");
				count++;
			}
		}
		
		if(count > max && check == 1) {
			max = count;
		}		
		if(max == 0) {
			return -1;
		}
		else {
			return max;
		}
    }
	
	public static void main(String[] args) {
		
		String s  = "a0bap5ffsF";
		int num = solution(s);
		System.out.print(num + "\n");
	}
}

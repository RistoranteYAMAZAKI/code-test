import java.util.*;

public class regular_match {


    public boolean isMatch(String s1, String s2) {  
        
		int check_s1 = 0, check_s2 = 0;
		
		if(s1.charAt(0) == '*' || s2.charAt(0) == '*') {
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != '*') {
				check_s1++;
			}
		}

		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i) != '*') {
				check_s2++;
			}
		}
		
		if(check_s1 == check_s2) {
			return true;
		}
		else {
			return false;
		}
		
    }

	public static void main(String[] args) {
		
		regular_match R = new regular_match();
		String str1 = "aa.b";
		String str2 = "a*b***c**************d";
		
		boolean condition = R.isMatch(str1, str2);
		System.out.print(condition + "\n");
	
	}


}
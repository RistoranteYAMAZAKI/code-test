import java.util.*;

public class Reverse_Int {

    public static void reverse(String s) {  
		
		String s1 = "", s2 = "", s3 = "";
		if(s.indexOf("-") == 0) {
			s1 = s.substring(1, s.length());
			s2 = new StringBuilder(s1).reverse().toString();
			s3 = "-" + s2;
		}
		else {
			s3 = new StringBuilder(s).reverse().toString();
		}
		long l = Long.parseLong(s3);
		if(l > 2147483647 || l <= -2147483648) {
			System.out.print("0" + "\n");
			return;
		}
		
		String tmp = "", tmp2 = "";
		if(s.indexOf("-") == 0) {
			tmp = s.substring(1, s.length());
			//System.out.print(tmp + "\n");
			tmp2 = new StringBuilder(tmp).reverse().toString();
			System.out.print("-" + tmp2 +  "\n");
			
		}
		else {
			System.out.print(new StringBuilder(s).reverse().toString() + "\n");
		}
		
    }

	public static void main(String[] args) {
		
		int number = -21474;
		reverse(Integer.toString(number));	
		
	}
}
import java.util.*;

public class Longest_Palindromic {


    public static void longest_palindromic(String s) {  
       
		String s_reverse = new StringBuilder(s).reverse().toString();
		String result = LCS(s, s_reverse);
		System.out.print(result + "\n");
    }

    public static String LCS(String a, String b) {  
		int aLen = a.length();
		int bLen = b.length();
		if(aLen == 0 || bLen == 0) {
			return "";
		}else if(a.charAt(aLen-1) == b.charAt(bLen-1)) {
			return LCS(a.substring(0,aLen-1),b.substring(0,bLen-1))
				+ a.charAt(aLen-1);
		}else {
			String x = LCS(a, b.substring(0,bLen-1));
			String y = LCS(a.substring(0,aLen-1), b);
			return (x.length() > y.length()) ? x : y;
		}
		
    }
	
	public static void main(String[] args) {
		
		String str = "baacdkeekssS";
			
		
		longest_palindromic(str);
	
	
	}


}
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Shortest_Palindrome {


	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);

		String str1 = "";
		for(int i = 0; i < 1; i++){
			str1 = in.nextLine();
		}
		
		String str2 = new StringBuilder(str1).reverse().toString();
		
		//String str1 = "bcaacbdacba";
		//String str2 = "abcadbcaacb";

		//String str1 = "aacecaaa";
		//String str2 = "aaacecaa";
		
		int m = str1.length();
		int n = str2.length();
		
		if(m < n){
			String str3 = str2;
			str2 = str1;
			str1 = str3;

			int tmp = n;
			n = m;
			m = tmp;			
		}
		

		int max = 0;
		int combine = 0;
		int check = 1;
		
		int num = 0;
		
		String s = "";
		String tmp = "";

		for(int i = 1; i <= n; i++){
			combine = combine + i;
		}
		
		while(check != combine+1){
			
			if(num == n){
				num = 0;
				n = n-1;
				
			}
			
			for(int i = num; i < n; i++){									
				s = s.concat( String.valueOf(str2.charAt(i)) ); 	
			}
			
			if(str1.contains(s)){
				
				if( s.length() > max ){
					
					max = s.length();
					tmp = s;
				}
				
			}
			
			s = "";
			
			
			//System.out.print("\n");
			num++;

			
			check++;
			
		}

		int a = str1.indexOf(tmp);
		int leng = tmp.length();
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i = 0; i < str1.length(); i++){
			
			if( i < a || i >= (a+leng) ){
				temp.add( String.valueOf( str1.charAt(i) ) );
			}
			else{
				i = i+leng-1;
				temp.add(tmp);
			}
			
			
		}
		
		for(int i = temp.size()-1; i >= 0; i--){
			System.out.print(temp.get(i));
		}
		for(int i = 1; i < temp.size(); i++){
			System.out.print(temp.get(i));
		}		
		
		System.out.print("\n");
		
	}
	

}
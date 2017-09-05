import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class string_segement {


	public static void main(String[] args) {

		String s = "acleetcodeluab";
		String[] dict = {"leet", "code" ,"luab", "ac"};
		

		/*
		s.substring( 0, s.indexOf(dict[0]));
		String s2 = s.substring( 0, s.indexOf(dict[0]));
		String s3 = s.substring( s.indexOf(dict[0])+dict[0].length() , s.length());
		
		System.out.println(s); 
		System.out.println(s2); 
		System.out.println(s3); 
		*/
		int check = 1;
		
		for(int i = 0; i < dict.length; i++){
			
			if(s.contains(dict[i])){
				//System.out.println(s); 
				s.substring( 0, s.indexOf(dict[i]));
				String s2 = s.substring( 0, s.indexOf(dict[i]));
				String s3 = s.substring( s.indexOf(dict[i])+dict[i].length(), s.length());
				s2 = s2.concat("-");
				s = s2.concat(s3);
				
			}
			else{
				check = 0;
				
			}
			//System.out.println(s); 
			
		}
		
		//System.out.println(s); 
		char[] array = s.toCharArray();
		//System.out.println(array.length); 
		
		for(int i = 0; i < array.length; i++){
			if(array[i] == '-' ){
				continue;
			}
			else{
				check = 0;
			}
		}

		if(check == 1){
			
			
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
		
		


	}

}
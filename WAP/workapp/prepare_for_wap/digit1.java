import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class digit1 {


	public static void main(String[] args) {

		int m = 0;	
		int check = 0;
		Scanner in = new Scanner(System.in);		
        m = in.nextInt();
		//System.out.println("\n");
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = m; i >= 0; i--){
			
			if( String.valueOf(i).contains("1") ){
				temp.add(i);
				//System.out.println(i);
				
			}
			else{
				continue;
			}
			
		}
	/*
		for(int i = 0; i < temp.size(); i++){
			
			System.out.println(temp.get(i));
		}
		*/
		int l = 0;
		for(int i = 0; i < temp.size(); i++){
			
			l = String.valueOf(temp.get(i)).length();
			//System.out.println(l);
			for(int j = 0; j < l; j++){
				
				String s = String.valueOf(temp.get(i));
				
				if( s.charAt(j) == '1' ){
					check++;
				}
			}
			
			
			
		}
		System.out.println(check);
	
	
	}
	

}
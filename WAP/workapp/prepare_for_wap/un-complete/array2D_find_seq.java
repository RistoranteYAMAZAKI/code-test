import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class array2D_find_seq {


	public static void main(String[] args) {

		String[][] array = {{"A", "B", "C", "E"},
								  {"S", "F", "C", "S"},
								  {"A", "D", "E", "E"}};
								  
		String str = "ABCCED";
	
		//System.out.println(array.length); //3
		//System.out.println(array[0].length);  //4
		int m = array.length;
		int n = array[0].length;
		


		for(int i = 0; i < m; i++){

			for(int j = 0; j < n; j++){
	
				for(int k = 0; k < str.length(); k++){

					if( array[i][j] == str.charAt(k) ){
						
						
					} 
					else{
						break;
					}				
				
				}	
				
			}			
		
			
		}
			
		
		
	
	}
	

}
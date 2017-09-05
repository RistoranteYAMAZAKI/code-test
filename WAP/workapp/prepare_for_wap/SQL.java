import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class SQL {


	public static void main(String[] args) {


	
		
		int[][] table = {{1, 100},
						 {2, 200},
						 {3, 300},
						 {4, 300},
						 {2, 400}};
			
		int max1 = 0;
		int max2 = 0;
		int first_time = 0;
		
		
	
		for(int i = 0; i < table.length; i++){
			
			if(table[i][1] > max1){
				max2 = max1;
				max1 = table[i][1];
				if(first_time == 0){
					first_time++;
					continue;
				}
			}		
			else if(table[i][1] < max1 && table[i][1] > max2){
				max2 = table[i][1];
			}
			else
				continue;
			
		}
		//System.out.println(max1 + " " + max2);
		System.out.println(table.length);
		if(table.length < 3){
			if(table[0][1] == table[1][1]){
				System.out.println("null");
			}
			else{
				System.out.println(max2);
			}
		}
		else if(max1 == max2){
			System.out.println("null");
		}
		else{
			System.out.println(max2);
		}
			
			
		
		
		
	}
	

}
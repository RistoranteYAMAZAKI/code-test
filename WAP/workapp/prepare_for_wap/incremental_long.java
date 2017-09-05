import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class incremental_long {


	public static void main(String[] args) {

		int[] number = {0, 1, 66, 41, 41, 6, 7, 19, 1, 9, 52, 53, 57, 66, 78, 1, 5, 8, 11, 13, 15};	

		//int[] number = {1, 2, 3};
		//ArrayList<String> input_line = new ArrayList<String>();		
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		
		int max = -1;  //must check the sequence of number which is most small, max number must lower than it
		int max_for_list = 0;
		int check = 0;
		int bound = number.length;
		//System.out.println(bound);  19
		
		while(check != bound-1){
			
			//System.out.println("aa");
			
			for (int i = check; i < number.length; i++ ){
					if(number[i] > max){
						if(i == number.length-1){
							max = number[i];
							temp1.add(number[i]);
							check = i;							
						}
						else{
							max = number[i];
							temp1.add(number[i]);							
						}
						
					}
					else{
						check = i;
						max = -1;
						break;
					}
			}		
				
			
			if(temp1.size() > max_for_list){
				max_for_list = temp1.size();
				temp2.clear();
				for (int i = 0; i < temp1.size(); i++ ){

					temp2.add(temp1.get(i));
					
				}				
			}
			
			temp1.clear();
			
		}
		
		//System.out.println(temp1.get(i));
		//System.out.print(temp1.get(i));
		
		for (int i = 0; i < temp2.size(); i++ ){
			System.out.print(temp2.get(i) + " ");			
		}		
		System.out.print("\n");

	}

}
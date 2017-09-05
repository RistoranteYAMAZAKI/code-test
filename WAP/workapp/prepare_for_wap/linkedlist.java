import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class linkedlist {


	public static void main(String[] args) {

		//remove duplicate itemsets in linked list
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int a[] = {1, 1, 1, 2, 3, 3, 5, 78, 3, 5, 2, 55};
		int check = 0;
		int match_index = 0;
		int first_time = 0;
		int duplicate = 0;
		
		for(int i = 0; i < a.length; i++){
			
			list.add(a[i]);
		}
		
		//System.out.println(list);
		
		while( check != list.size()){
			
			if(first_time == 0){
				result.add(list.get(0));
				first_time++;
			}
			
			for(int i = 0; i < result.size(); i++){
				
				if( list.get(check) == result.get(i) ){
					duplicate = 1;
					break;
				}
				
			}
			
			if(duplicate != 1){
				result.add(list.get(check));
			}
		
			duplicate = 0;
			check++;
		}

		for(int i = 0; i < result.size(); i++){
			
			System.out.println(result.get(i));
		}		
		
	}
	

}
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class linkedlist_process {


	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);
		
		String str1 = "";
		for(int i = 0; i < 1; i++){
			str1 = in.nextLine();
		}
		
		int k = 3;
		int check = 0;

		String[] line = str1.split(" ");
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i = 0; i < line.length; i++){
			list.add(line[i]);
		}
		
		for(int i = 0; i < list.size(); i++){
			if( Integer.parseInt(list.get(i)) == k){
				check = i;
			}
			else
				continue;
		}
		
		LinkedList<String> mod_equal_zero = new LinkedList<String>();
		LinkedList<String> mod_not_zero = new LinkedList<String>();
		
		for(int i = check+1; i < list.size(); i++){
			if(Integer.parseInt(list.get(i)) % k == 0){
				mod_equal_zero.add(list.get(i));
			}
			else{
				mod_not_zero.add(list.get(i));
			}
		}
		
		for(int i = check; i >= 0; i-- ){
			System.out.print(list.get(i) + " ");
		}
		
		for(int i = 0; i < mod_equal_zero.size(); i++ ){
			System.out.print(mod_equal_zero.get(i) + " ");
		}		
		for(int i = 0; i < mod_not_zero.size(); i++ ){
			System.out.print(mod_not_zero.get(i) + " ");
		}
		
		System.out.print("\n");
	}
	

}
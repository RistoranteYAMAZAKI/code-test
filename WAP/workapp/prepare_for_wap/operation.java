import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class operation {


	public static void main(String[] args) {

		int check = 0;
		int cal = 0; 
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> input_line = new ArrayList<String>();
		ArrayList<String> temporal = new ArrayList<String>();
		String[] temp = new String[100];
		
		for(int i = 0; i < 1; i++){
			temp = in.nextLine().split(" ");
		}
		//System.out.println(temp[0] + " " + temp[1]);
		//2 1 + 3 *
		//4 13 5 / +
		
		for(int i = 0; i <temp.length; i++){
			input_line.add(temp[i]);
		}
		
		
		while(input_line.size() != 1){
			int i = 0;
			for(i = 0; i < input_line.size(); i++){
				if(input_line.get(i).equals("+") || input_line.get(i).equals("-") || input_line.get(i).equals("*") || input_line.get(i).equals("/")){
					check = i;
					break;
				}
				else{
					continue;
				}	
			}
				
			if(input_line.get(check).equals("+")){
				cal = Integer.parseInt(input_line.get(check-2)) + Integer.parseInt(input_line.get(check-1));
			}
			if(input_line.get(check).equals("-")){
				cal = Integer.parseInt(input_line.get(check-2)) - Integer.parseInt(input_line.get(check-1));
			}
			if(input_line.get(check).equals("*")){
				cal = Integer.parseInt(input_line.get(check-2)) * Integer.parseInt(input_line.get(check-1));
			}
			if(input_line.get(check).equals("/")){
				cal = Integer.parseInt(input_line.get(check-2)) / Integer.parseInt(input_line.get(check-1));
			}
			
			for(int j = 0; j < input_line.size(); j++){
				
				if(j == check-1 || j == check-2){
					continue;
				}
				else if(j == check){
					temporal.add(String.valueOf(cal));
				}
				else{
					temporal.add(input_line.get(j));
					
				}
					
			}
			
			
			input_line.clear();
			
			for(int j = 0; j < temporal.size(); j++){
				
				input_line.add(temporal.get(j));
			}
			temporal.clear();
			check = 0;
			cal = 0;


			
		}
		
		System.out.println("Answer is : " + input_line.get(0));
		
		
	}
	

}
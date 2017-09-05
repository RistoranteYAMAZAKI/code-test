import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) throws IOException {


		int first_line = 0;
		int first_city = 0;
		int query_line = 0;
		int query_first = 0;
		
		int n = 0;
		int m = 0;		

		Scanner in = new Scanner(System.in);
		
        n = in.nextInt();
        m = in.nextInt();	
		
		int length = n;   //
		int[][] origin_array = new int[length+1][length+1];	
		int[][] calculate_array = new int[length+1][length+1];	
		
		int distance = 0;
		int find = 0;
		
		String[] temp = new String[2];
		//int[] temp = new int[2];
		
		int establish_city = 0;
		int establish_city_check = 0;
		
		int festival_city = 0;

		int line_num = 1;
			
		
		ArrayList<String> input_line = new ArrayList<String>();
		
		for(int i = 0; i < n+m; i++){
			input_line.add(in.nextLine());
		}
		establish_city = n-1;
		
		//****************************************************
		//The method i use is read file and output result to file
		//Type of input and output just like requirement
		//If WAP Engineer test my code, please provide input.txt the same as sample test or other test data
		//input.txt must put on the path the same as my code city.java
		//compile >> javac city.java	run >> java city
		//****************************************************
		
		
		//Following please change the path for your environment. 
		//FileReader fr = new FileReader("/home/hdc/workapp/input.txt");
		//FileWriter fw = new FileWriter("/home/hdc/workapp/output.txt");							
		//BufferedReader br = new BufferedReader(fr);
		
		ArrayList<Integer> distance_temp = new ArrayList<Integer>();
		ArrayList<Integer> aL_temp = new ArrayList<Integer>();
		
		while ( line_num != input_line.size() ) {
			
			distance = 0;
			
			//String s10 = br.readLine();
			/*
			if(first_line == 0){
				
				temp = br.readLine().split(" ");
				first_line++;
				establish_city = Integer.parseInt(temp[0])-1;
				//System.out.print(establish_city + "\n");
				continue;
			}
			*/
			
			if(establish_city == establish_city_check || query_line != 0){
				
				/*
				for (int i = 0; i < origin_array.length; i++) {
					for (int j = 0; j < origin_array.length; j++) {
						
						fw.write(origin_array[i][j] + " ");
					}
					fw.write("\n");
				}	
				fw.write("\n");
				fw.write("\n");
				*/
				
				
				query_line++;
				query_first = 0;
				//System.out.println("check find > ");
				
				//more faster copy array instead of use two for loop
				for (int i = 0; i < origin_array.length; i++) {
					System.arraycopy(origin_array[i], 0, calculate_array[i], 0, origin_array[0].length);
				}	
				
				temp = input_line.get(line_num).split(" ");
				
				if( Integer.parseInt(temp[0]) == 1){ // Government announce
					festival_city = Integer.parseInt(temp[1]);
					line_num++;
					continue;
				}
				else{
					
					//System.out.println("start find > " + Integer.parseInt(temp[0]));
					
					while(find != 1){
						
						//System.out.println("while find > ");
						
						if(query_first == 0){
							distance_temp.add( Integer.parseInt(temp[1]) ); 
							query_first++;
						}

											
							
						for (int i = 0; i < distance_temp.size() ; i++) {
							//System.out.println(distance_temp.get(i));
							
							for (int j = 0; j < calculate_array.length; j++) {
								
								
								if( calculate_array[distance_temp.get(i)][j] == 1){
									
									if(festival_city == distance_temp.get(i)){
										//it just a festival city, so distance is 0
										find = 1;
										System.out.println(0);
										//fw.write("0" + "\n");
										break;
									}									
									
									if(festival_city == j){
										distance++;
										find = 1;
										System.out.println(distance);
										//fw.write(distance + "\n");
										break;
									}
									else{
										
										
										calculate_array[distance_temp.get(i)][j] = 0;
										calculate_array[j][distance_temp.get(i)] = 0;
										aL_temp.add(j);

									}

									
								}
									
								
									
							}
							
						}
						//System.out.println("check two for > ");
						distance_temp.clear();
						
						if(find != 1){
							distance_temp = new ArrayList<Integer>(aL_temp);
						}
						
						aL_temp.clear();
						distance++;

					}//end while for find distance 
					find = 0;
					//System.out.println("check else > ");
				}

			}
			else{
				
				temp = input_line.get(line_num).split(" ");
				
				if(first_city == 0){
					festival_city = 1;
					//festival_city = Integer.parseInt(temp[0]);
					first_city++;
				}
				
				origin_array[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
				origin_array[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
				
			}
			
			
			establish_city_check++;
			line_num++;
		}
		
	
        //fw.flush();
        //fw.close();
		//fr.close();
	               
		


	}
}


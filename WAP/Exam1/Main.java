import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;

public class Main {

    public static int[] function(int calculate_array[][], int node, int row, int col, int N, int M, int is_right) {
        int dist = 0;
		int max = 0;
		int no_right = 0;
		int no_up = 0;
		int no_down = 0;	
		int right_check = 0;
		//int[] result = new int[2];	
		
		int a = 0;
		int b = 0;
		int[][] debug = new int[N][M];
		//int[][] debug2 = new int[N][M];
		
		
		//more faster copy array instead of use two for loop
		for (int c = 0; c < calculate_array.length; c++) {
			System.arraycopy(calculate_array[c], 0, debug[c], 0, calculate_array[0].length);
		}

		
		ArrayList<Integer> vertex_can_visit = new ArrayList<Integer>();
		int[][] visit_row_col = new int[3][2];		
		
		//visit right or not
		if( col+1 > M-1 || calculate_array[row][col+1] == -1 ){
			no_right++;
		}
		else{
			vertex_can_visit.add(calculate_array[row][col+1]);
			visit_row_col[a][0] = row;
			visit_row_col[a][1] = col+1;
			a++;
		}
		
		//visit up or not
		if( row-1 < 0 || calculate_array[row-1][col] == -1 ){
			no_up++;
		}
		else{
			vertex_can_visit.add(calculate_array[row-1][col]);
			visit_row_col[a][0] = row-1;
			visit_row_col[a][1] = col;
			a++;			
		}		

		//visit down or not
		if( row+1 > N-1 || calculate_array[row+1][col] == -1 ){
			no_down++;
		}
		else{
			vertex_can_visit.add(calculate_array[row+1][col]);
			visit_row_col[a][0] = row+1;
			visit_row_col[a][1] = col;
			a++;				
		}

		/*
		for(int i = 0; i < vertex_can_visit.size(); i++){
			System.out.println(node);
			System.out.println(vertex_can_visit.get(i));
		}
		System.out.println("\n");	
		*/
		
		if(no_right == 1 && no_up == 1 && no_down == 1){

			
			if(col == M-1){
				is_right = 1;
			}
			//System.out.println("last : " + node);
			return new int[] {node, is_right};
			
		}
		
		for(int k = 0; k < vertex_can_visit.size(); k++){
			
			calculate_array[row][col] = -1;
			
			//System.out.println("inter : " + vertex_can_visit.get(k));
			
			//cost = function(calculate_array, origin_array[i][0], i, 0, n, m);
			int[] result = function(calculate_array, vertex_can_visit.get(k), visit_row_col[k][0], visit_row_col[k][1], N, M, is_right);
			
			dist = node + result[0];
			
			if(result[1] == 1){  //last position in right side
				if(dist > max){
					right_check++;
					max = dist;
					//System.out.println("inter yes: " + vertex_can_visit.get(k));
					//System.out.println("inter max is : " + max);
				}				
			}
			else{
				
				if(dist > max){
					
					max = dist;
					//System.out.println("inter no: " + vertex_can_visit.get(k));
					//System.out.println("no right inter max is : " + max);
				}
			}
			
			for (int c = 0; c < debug.length; c++) {
				System.arraycopy(debug[c], 0, calculate_array[c], 0, debug[0].length);
			}			
			
		}		
		
		
		return new int[] {max, right_check}; //or return dist
		
    }


	
    public static void main(String[] args) {

		int n = 0;
		int m = 0;
		int cost = 0;
		int Max = 0;
		int check_final_position = 0;
		
		int block = 0;
		int check_block2 = 0;
		int block2 = 0;
		
		int teleport_check = 0;
		int teleport_check2 = 0;
		
		//int[] Final = new int[2];

		int special_up_left_x = 0;
		int special_up_left_y = 0;
		int special_down_right_x = 0;
		int special_down_right_y = 0;
		
		int output_check = 0;
		
		Scanner in = new Scanner(System.in);
		
        n = in.nextInt();
        m = in.nextInt();	
		
		String[] temp = new String[m];
		int[] unreach_check = new int[n];
		int[] teleport = new int[m];
		
		for(int i = 0; i < n; i++){
			unreach_check[i] = 120000;
		}
		for(int i = 0; i < m; i++){
			teleport[i] = 120000;
		}		
		
		int unreach = 0;
		int unreach_con = 0;
		int unreach_lastline_condision = 0;
		
		
		int[][] origin_array = new int[n][m];			
		int[][] calculate_array = new int[n][m];

		
		ArrayList<String> input_line = new ArrayList<String>();
		for(int i = 0; i <= n; i++){
			input_line.add(in.nextLine());
		}		
	
		/*		
		for(int i = 1; i < input_line.size(); i++){
			System.out.println(input_line.get(i));					
		}		
		*/
		
		//establish snake origin array
		for(int i = 0; i < n; i++){
		
		    temp = input_line.get(i+1).split(" ");
			
			for(int j = 0; j < m; j++){
				origin_array[i][j] = Integer.parseInt(temp[j]);
			    //System.out.println(Integer.parseInt(temp[j]));	
			}	
		}	
		
		//check if or not reach right side && one line for teleport 
		int save_once = 0;
		
		for(int i = 0; i < n; i++){
			
			for(int j = 0; j < m; j++){
				
				if(origin_array[i][j] == -1){ 
					unreach_check[i] = j+1;   //for block output -1
					teleport[j] = i+1;        //for teleport
				}
				
				if(n == 1 && origin_array[i][j] == -1){
					block = 1;
					
				}				
			}	
		}	


		
		//check if or not reach right side
		for(int i = 1; i < n; i++){
			
			if( Math.abs( unreach_check[i] - unreach_check[i-1] ) < 2 ){
				unreach++;
			}			
		}
		
		//check if or not reach right side
		for(int i = 0; i < n; i++){
			
			if( unreach_check[i] != 120000 ){
				block2++;
			}
			
		}

		int special_teleport = 0;  //block
		int special_teleport2 = 0; //no block
		int first_time = 0;
		
		if(block2 == n){


			
			
			
			//***** can teleport but also block >> special vertex 
			for(int i = 1; i < m-2; i++){
				
				if( teleport[i-1] == 120000 && teleport[i] != 120000 && teleport[i+1] != 120000 && teleport[i+2] == 120000){
					special_teleport = 10;
				}			
			}

			
			//can teleport but like block
			for(int j = 0; j < m; j++){
				
				if(origin_array[0][j] == -1){
					first_time++;
				}
				else{
					continue;
				}	
				
				//System.out.println(origin_array[0][j+1] + " " + origin_array[n-1][j+1]);
				
				if(origin_array[0][j+1] != -1 && origin_array[n-1][j+1] != -1){
					special_teleport2 = 20;
					break;
				}
				else{
					special_teleport2 = 0;
					break;
				}
				
							
			}			
			
		}
		
		//check if or not reach right side	
		for(int j = 0; j < m; j++){
			
			if(origin_array[n-1][j] == -1){
				unreach_lastline_condision++;		
			}	
		}	
		//check if or not reach right side
		if(unreach_lastline_condision == 1){
			if(origin_array[n-1][m-1] == -1 && origin_array[0][0] == -1)
				unreach--;
		}
		
		//check teleport condition
		for(int i = 1; i < m; i++){
			
			if( Math.abs( teleport[i] - teleport[i-1] ) < 2 ){
				teleport_check2++;
			}			
		}
		
		//check teleport condition
		for(int i = 0; i < n; i++){
			
			if( teleport[i] != 120000 ){
				teleport_check++;
			}
			
		}	
		
		if(special_teleport == 0 && special_teleport2 == 20){
			unreach--;
		}
		
		
		//System.out.println(unreach + " " + block2 + " " + special_teleport  + " " + block + " " + special_teleport2 );
		
		//check if or not reach right side
		if( (unreach == n-1 && block2 == n && special_teleport != 0) || block == 1 || unreach == n-1 ){  //|| teleport_check != m ??
			//System.out.println("can not reach");
			output_check = 1;
			System.out.println(-1);
		}
		else if( (teleport_check == m && teleport_check2 == m-1) || (special_teleport == 0 && special_teleport2 == 20) ){  // handle teleport
			//System.out.println("teleport condition");
			
			int[][] up = new int[n][m];
			int[][] down = new int[n][m];
			
			//more faster copy array instead of use two for loop
			for (int c = 0; c < origin_array.length; c++) {
				System.arraycopy(origin_array[c], 0, up[c], 0, origin_array[0].length);
			}
			//more faster copy array instead of use two for loop
			for (int c = 0; c < origin_array.length; c++) {
				System.arraycopy(origin_array[c], 0, down[c], 0, origin_array[0].length);
			}	
			// fill down
			for(int i = 0; i < n; i++){
				
				for(int j = 0; j < m; j++){
					
					if(up[i][j] == -1){ 
					
						if(i == n-1){
							continue;
						}
						else{
							for(int k = i+1; k < n; k++){
								up[k][j] = -1;
							}							
						}
					
					}
					
				}	
			}		
			
			// fill up
			for(int i = 0; i < n; i++){
				
				for(int j = 0; j < m; j++){
					
					if(down[i][j] == -1){ 
					
						if(i == 0){
							continue;
						}
						else{
							for(int k = i-1; k >= 0; k--){
								down[k][j] = -1;
							}							
						}
					
					}
					
				}	
			}


			
			int half_check = 1000;
			int h_c = 0;
			for(int i = 0; i < n; i++){
				
				for(int j = 0; j < m; j++){
					
			
					if(origin_array[i][j] == -1){
						half_check = j;
						break;
					}
	
				}
				
				if(half_check != 1000){
					break;
				}
				
			}
			
			//System.out.println(half_check); 
			int condition = 0; 
			int move_con1 = 0;
			
			if(half_check < (int)(m-1)/2 ){
				condition = 1;
			}
			else{
				condition = 2;
			}
			
			if(condition == 1){
				
				int c1 = 1000;
				for(int i = 0; i < m; i++){					
					for(int j = 0; j < n; j++){
						if(up[j][i] != -1){
							move_con1 = i;
							c1++;
							break;
						}
					}
					if(c1 != 1000)
						break;
				}
				//System.out.println(move_con1); 
				
				int[][] newarray = new int[n][m-move_con1];
				
				for(int i = 0; i < n; i++){					
					for(int j = move_con1; j < m; j++){
						newarray[i][j-1] = up[i][j];
					}	
				}

				
				if(origin_array[0][0] == -1 && origin_array[n-1][m-1] == -1){
					
					for(int i = 0; i < n; i++){

						//System.out.println(origin_array[i][0]); //print left border
					
						if(newarray[i][0] == -1){							
							continue;
						}
						
						int[] Final_tel = function(newarray, newarray[i][0], i, 0, n, m-move_con1, check_final_position);
						cost = Final_tel[0];

						if(Final_tel[1] == 0){							
							if(cost > Max){							
								Max = cost;
							}						
							check_final_position = 0;
						}
						else{
							if(cost > Max){
								Max = cost;
							}				
							check_final_position = 0;
						}
						
					}
					
					
				}
				else{

					for(int i = 0; i < n; i++){

						//System.out.println(origin_array[i][0]); //print left border
					
						if(newarray[i][0] == -1){							
							continue;
						}
						
						int[] Final_tel = function(newarray, newarray[i][0], i, 0, n, m-move_con1, check_final_position);
						cost = Final_tel[0];

						if(Final_tel[1] == 0){							
							if(cost > Max){							
								Max = cost;
							}						
							check_final_position = 0;
						}
						else{
							if(cost > Max){
								Max = cost;
							}				
							check_final_position = 0;
						}
						
					}
					
					for(int i = 0; i < n; i++){

						//System.out.println(origin_array[i][0]); //print left border
					
						if(down[i][0] == -1){							
							continue;
						}
						
						int[] Final_tel = function(down, down[i][0], i, 0, n, m, check_final_position);
						cost = Final_tel[0];

						if(Final_tel[1] == 0){							
							if(cost > Max){							
								Max = cost;
							}						
							check_final_position = 0;
						}
						else{
							if(cost > Max){
								Max = cost;
							}				
							check_final_position = 0;
						}
						
					}					
					
					
				}
				
			}
			//else
			//Sat need to go home, if having time 
			//here have condition 2 to do, write on paper 5
			
	
		}
		else{ //complexity part - no teleport
			//System.out.println("can reach");
			//System.out.println(unreach);
			//System.out.println("normal condition");	
			
			for(int i = 0; i < n; i++){

				//System.out.println(origin_array[i][0]); //print left border
			
				if(origin_array[i][0] == -1){
					//System.out.println("start is -1 ");
					continue;
				}

				
				//more faster copy array instead of use two for loop
				for (int c = 0; c < origin_array.length; c++) {
					System.arraycopy(origin_array[c], 0, calculate_array[c], 0, origin_array[0].length);
				}
				
				
				//function (array, node, i,j,n,m)
				//System.out.println(origin_array[i][0] + " " + i + " " + n + " " +  m + " " +  check_final_position);
				int[] Final = function(calculate_array, origin_array[i][0], i, 0, n, m, check_final_position);
				
				cost = Final[0];
				
				if(Final[1] == 0){
						
					//System.out.println(-2);
					
					//fowllowing maybe wrong, it just my assume that not at right border finally also can include
					//because if left node has another path to right border, intuitively, it may larger than path
					//which doesn't achieve right border
					if(cost > Max){
						
						Max = cost;
						
					}						
					check_final_position = 0;
					
				}
				else{

					if(cost > Max){
						
						Max = cost;
						
					}				
					check_final_position = 0;
					
					
				}
						
				
			}
			
			
		}
			
		//System.out.println("\n");
		if(output_check  != 1){
			System.out.println(Max);
		}
        
    }

}
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class bulb_switcher {


	public static void main(String[] args) {

		int bulb_number = 9;
		
		int switch_time = 0; 
		int round = 4;//assign
		
		int first = 0;
		int last = 0;
		
		int on_num = 0;
		
		//Scanner in = new Scanner(System.in);
	
        //bulb_number = in.nextInt();
		// 0 is off, 1 is on
		int[] array = new int[bulb_number];
		
		while(switch_time != round){

			if(first == 0){
				
				for(int i = 0; i < bulb_number; i++){
					
					array[i] = 1;
					
				}
				first++;
			}
			else if(switch_time == round-1){
				if(array[bulb_number-1] == 0 ){
					array[bulb_number-1] = 1;
				}
				else{
					array[bulb_number-1] = 0;
				}
					
			}
			else{
				//System.out.println("nnnnn");
				for(int i = 0; i < bulb_number; i++){
					
					if( (i+1)%(switch_time+1) == 0 ){
						if(array[i] == 0){
							array[i] = 1;
						}
						else{
							array[i] = 0;
						}
						
						
					}
					else{
						continue;
					}
					
				}				
				
			}
					
	
			switch_time++;
			
		}
		
		for(int i = 0; i < array.length; i++){
			//System.out.println(array[i]);
			if(array[i] == 1){
				on_num++;
			}
		}
		System.out.println(on_num);
		
		
		
	}
	

}
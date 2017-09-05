import java.util.*;

public class clock {


    public static void find_max_time(int[] array) {  
       
	    //time = ab:cd
		int max_hour = 0;
		int max_minute = 0;
		int tmp1 = 0;
		int tmp2 = 0;
		//ab:xx
		int index_a = 0;
		int index_b = 0;
		
		int error_1 = 0;
		int error_2 = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = i+1; j < array.length; j++) {
				
				tmp1 = array[i]*10+array[j];
				if(tmp1 >= max_hour && tmp1 < 24) {
					max_hour = tmp1;
					index_a = i;
					index_b = j;
					error_1++;
				}

				
				tmp1 = array[j]*10+array[i];
				if(tmp1 >= max_hour && tmp1 < 24) {
					max_hour = tmp1;
					index_a = j;
					index_b = i;
					error_2++;
				}				
				
			}
			
		}
		
		if((error_1 + error_2) == 0){
			System.out.print("error time" + "\n");
			return;
		}
		error_1 = 0;
		error_2 = 0;
		
		ArrayList<Integer> minute = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			if(i == index_a || i ==index_b) {
				continue;
			}
			else {
				minute.add(array[i]);
			}
		}
		
		tmp2 = minute.get(0)*10+minute.get(1);
		if(tmp2 >= max_minute && tmp2 < 60) {
			max_minute = tmp2;
			error_1++;
		}
		tmp2 = minute.get(1)*10+minute.get(0);
		if(tmp2 >= max_minute && tmp2 < 60) {
			max_minute = tmp2;
			error_2++;
		}
		
		if((error_1 + error_2) == 0) {
			System.out.print("error time" + "\n");
		}		
		else {
			System.out.print("Time is " + max_hour + ":" + max_minute + "\n");
		}
		
		
    }

	public static void main(String[] args) {
		
		int[] number = {1,2,3,4};	
			
		
		find_max_time(number);
	
	
	}


}
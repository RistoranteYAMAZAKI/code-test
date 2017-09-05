import java.util.*;

public class sum_two {


    public void find_sum_two(int[] array, int target) {  
        int leng = 0;  
		int check = 0;
		leng = array.length;
		
        ArrayList<Integer> temp = new ArrayList<Integer>();
		//temp.clear();
		
		for (int i = 0; i < leng; i++ ){
			if(array[i] <= target)
				temp.add(array[i]);
		}
		
		//System.out.print(temp.get(check) + "\n");
		while(check != temp.size()){
			
			for (int i = check+1; i < temp.size(); i++ ){
				
				if ( (temp.get(check)+temp.get(i)) == target){
					System.out.print(check + " " + i + "\n");
				}
				
				
			}
			check++;			
		}
		
		
    }

	public static void main(String[] args) {
		
		sum_two S = new sum_two();
		int[] number = {2, 7, 11, 15, 13, 14, 17, 18, 6, 5, 9};	
		int target = 22;	
		
		S.find_sum_two(number, target);
	
	
	}


}
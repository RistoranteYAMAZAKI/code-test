import java.util.*;

public class shuffle_array {
	
	static ArrayList<String> store = new ArrayList<String>();
	
	public void permute(char[] input2, int startindex) {
		
		if(startindex == input2.length) {
			String str = "";
			for(int i = 0; i < input2.length; i++) {
				str = str + input2[i];
			}
			
			store.add(str);
		}
		else {
			for(int i = startindex; i < input2.length; i++){
				char[] input = input2.clone();
				char tmp = input2[i];
				input[i] = input[startindex];
				input[startindex] = tmp;
				permute(input, startindex + 1);
			}
		}
	}
	
	public void shuffle_display(int num) {
		
		Random ran = new Random();
		int r = ran.nextInt(num); //nextInt(num) == 0~num-1
		System.out.print("Shuffle output : "+ store.get(r) + "\n");
		
	}	

	
	public static void main(String[] args) {
		
		shuffle_array S = new shuffle_array();
		char[] array = {'1','2','3'};
		S.permute(array,0);
		S.shuffle_display(array.length*(array.length-1));
		
		/*
		for(String ele : store) {
			System.out.print(ele + "\n");
		}
		*/
		
	}
	
}
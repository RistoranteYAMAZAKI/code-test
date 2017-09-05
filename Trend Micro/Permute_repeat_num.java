import java.util.*;

public class Permute_repeat_num {
	
	static Set<String> set = new HashSet<String>();
	
	public void permute(char[] input2, int startindex) {
		
		String str = "";
		if(input2.length == startindex) {
			
			for (int i = 0; i < input2.length; i++) {
				str = str + input2[i];
			}
			//System.out.print(str + "\n");
			set.add(str);
		}
		else {
			for(int i = startindex; i < input2.length; i++) {
				char[] input = input2.clone();
				char tmp = input[i];
				input[i] = input[startindex];
				input[startindex] = tmp;
				permute(input, startindex + 1);
			}
		}
	
	}

	private static void displaySet() {
		for (String str : set) {
			System.out.print(str + "\n");
		}

	}
	
	public static void main(String[] args) {
		
		Permute_repeat_num P = new Permute_repeat_num();		
		
		int n = 1213;
		char[] input = ("" + n).toCharArray();
		//char[] input = { '1', '2', '1', '3'};
		//int num = input.length * (input.length-1);
		P.permute(input, 0);
		displaySet();
		
	}
	
}

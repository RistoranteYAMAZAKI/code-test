import java.util.*;

public class test3 {
	
	static Set<String> set = new HashSet<String>();
	
    public int solution(int N) {
        // write your code in Java SE 8
		
		if(N == 0) {
			return 1;
		}
		char[] chars = ("" + N).toCharArray();
		permute(chars, 0);
		
		for (String str : set) {
			System.out.print(str + "\n");
		}		
		
		return set.size();
    }

	public static void permute(char[] input2, int startindex) {
		
		String str = "";
		if(input2.length == startindex) {
			
			for (int i = 0; i < input2.length; i++) {
				str = str + input2[i];
			}
			//System.out.print(str + "\n");
			if(str.charAt(0) != '0') {
				set.add(str);
			}
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

	
	public static void main(String[] args) {
		
		test3 t = new test3();
		int n = 1234;
		int num = t.solution(n);
		System.out.print(num + "\n");
	}
}

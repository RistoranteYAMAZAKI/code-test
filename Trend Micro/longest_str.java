import java.util.*;

public class longest_str {


	public static void lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		int start = 0, end = 0, index_1 = 0, index_2 = 0;
		
		Set<Character> set = new HashSet<>();;
		
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				
				if(set.size() > max) {
					max = set.size();
					index_1 = end;
					index_2 = start;
				}
				end++;
			} else {
				set.remove(s.charAt(i++));
				start++;
			}
		}
		
		System.out.print(max + "\n");
		//System.out.print(index_2 + " " + index_1 + "\n");
		for(int k = index_2; k < index_1+1; k++) {
			System.out.print(s.charAt(k) + " ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		
		String str = "pwwkew";
			
		
		lengthOfLongestSubstring(str);
		
	
	}


}
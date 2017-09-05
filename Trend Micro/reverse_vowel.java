import java.util.*;

public class reverse_vowel {
	
	static final String vowels = "aeiouAEIOU";
	public String reverse(String s) {
		
		int first = 0, last = s.length() - 1;
		char[] array = s.toCharArray();
		while(first < last){
			while(first < last && vowels.indexOf(array[first]) == -1){
				first++;
			}
			while(first < last && vowels.indexOf(array[last]) == -1){
				last--;
			}
			char temp = array[first];
			array[first] = array[last];
			array[last] = temp;
			first++;
			last--;
		}
		return new String(array);
		
	}
	
	public static void main(String[] args) {
		
		reverse_vowel R = new reverse_vowel();
		String s = "leetcode";
		String str = R.reverse(s);
		System.out.print(str + "\n");
	}
	
}
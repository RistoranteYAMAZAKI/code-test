import java.util.*;

public class Wrapround_str_count {

	public static int calculate(int num) {
		int n = 0;
		for(int i = 1; i <= num ; i++) {
			n = n + i;
		}
		return n;
	}

    public void findSubstringInWraproundString(String p) {
        
		int[] record = new int[26];  //init to zero
		int sum = 0, tmp = 0, start = 0, end = record.length;
		int check = 0;
		
		for(int i = 0; i < p.length(); i++) {
			int index = p.charAt(i) - 'a';
			if(record[index] == 0){
				record[index] = 1;
			}
			else{
				continue;
			}
		}
		
		//deal with start & end 
		if(record[start] == 1 && record[end-1] == 1){
			System.out.print("aaa" + "\n");
			while(record[start] == 1) {
				start++;
				check++;
			}
			while(record[end-1] == 1) {
				end--;
				check++;
			}
			
			sum = sum + calculate(check);
			//System.out.print(sum + "\n");
			for(int i = start+1; i < end; i++) {
				if(record[i] == 0){
					sum = sum + calculate(tmp);
					tmp = 0;
					continue;
				}
				else {
					tmp++;
				}
			}
		}
		else {
			System.out.print("bbb" + "\n");
			for(int i = 0; i < record.length; i++) {
				if(record[i] == 0){
					//System.out.print(calculate(tmp) + " " + i + "\n");
					sum = sum + calculate(tmp);
					tmp = 0;
					continue;
				}
				else {
					tmp++;
					//System.out.print(i + "\n");
				}
			}
			sum = sum + calculate(tmp);
		}
		
		System.out.print(sum + "\n");
		
    }
	
	public static void main(String[] args) {
		
		String str = "bdeghijmnruxz";
		Wrapround_str_count W = new Wrapround_str_count();
		W.findSubstringInWraproundString(str);
		
	}
	
}

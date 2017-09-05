import java.util.*;

public class count_prime {
	
	public int count(int n) {
		boolean[] tmp = new boolean[n];
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(tmp[i] == false) {
				count++;
				
				for(int j = 2; i*j < n; j++){
					tmp[i*j] = true;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int n = 14;
		count_prime cp = new count_prime();
		System.out.print("number is : " + cp.count(n)+ "\n");
	}
	
}
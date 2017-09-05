import java.util.*;

public class Bulls_and_Cows {
	
	public void solution(String S, String G) {
		
		int A = 0;
		int B = 0;
		
		ArrayList<Integer> secret = new ArrayList<Integer>();
		ArrayList<Integer> guess = new ArrayList<Integer>();
		
		for(int i = 0; i < S.length(); i++) {
			secret.add(S.charAt(i) - '0');
			guess.add(G.charAt(i) - '0');
		}
		
		for(int i = 0; i < secret.size(); i++) {
			if(secret.get(i) == guess.get(i)) {
				A++;
				secret.remove(i);
				guess.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < guess.size(); i++) {
			for(int j = 0; j < secret.size(); j++) {
				if(guess.get(i) == secret.get(j)) {
					secret.remove(j);
					B++;
					break;
				}
			}
		}
		
		System.out.print(A + "A" + B + "B" + "\n");
		
	}
	
	public static void main(String[] args) {
		
		String secret = "7807";
		String guess = "7810";
		Bulls_and_Cows BC = new Bulls_and_Cows();
		BC.solution(secret, guess);
	}
}
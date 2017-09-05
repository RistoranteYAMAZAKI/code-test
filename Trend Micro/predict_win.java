import java.util.*;

public class predict_win {
	
	public boolean predict(ArrayList<Integer> input) {
		
		int l = input.size(), first = 1;
		int player1_sum = 0, player2_sum = 0;
		Random ran = new Random();
		
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		
		while(l != 0) {
			
			int num = ran.nextInt(2);
			if(num == 0){ //start
				if(first == 1) {
					player1.add(input.get(0));
					first++;
					input.remove(0);
				}
				else { //first == 2
					player2.add(input.get(0));
					first--;
					input.remove(0);					
				}
			}
			else { //end, num == 1
				if(first == 1) {
					player1.add(input.get(l-1));
					first++;
					input.remove(l-1);
				}
				else { //first == 2
					player2.add(input.get(l-1));
					first--;
					input.remove(l-1);					
				}				
			}
			l = input.size();
		}
		
		
		for(int i = 0; i < player1.size(); i++) {
			player1_sum = player1_sum + player1.get(i);
			System.out.print("Player 1 : " + player1.get(i) + " ");
		}
		System.out.print("\n");

		for(int i = 0; i < player2.size(); i++) {
			player2_sum = player2_sum + player2.get(i);
			System.out.print("Player 2 : " + player2.get(i) + " ");
		}
		System.out.print("\n");
		
		return (player1_sum > player2_sum) ? true : false;
	}	
	
	public static void main(String[] args) {
		
		//List<Integer> input = new ArrayList<Integer>();
		predict_win P = new predict_win();
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(5);
		input.add(233);
		input.add(7);
		input.add(8);
		input.add(11);
		input.add(14);
		input.add(19);
		input.add(33);
		//input.add(32);
		
		System.out.print(P.predict(input) + "\n");
	
		
	}
}
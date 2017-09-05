import java.util.*;

public class group_anagram {
	
	public static ArrayList<String> store;
	
	public static void permute(char[] input2, int startindex) {
		
		if(startindex == input2.length) {			
			displayArray(input2);	
		}else {
			for (int i = startindex; i < input2.length; i++) {
				char[] input = input2.clone();
				char temp = input[i];
				input[i] = input[startindex];
				input[startindex] = temp;
				permute(input, startindex + 1);
			}
		}
	}

	private static void displayArray(char[] input2) {
	
			String tmp = "";
			for (int i = 0; i < input2.length; i++) {
				tmp = tmp + input2[i];
			}
			store.add(tmp);
	
	}
	
	public void find_anagram(ArrayList<String> list) {
		
		while(list.size() != 1){
			store = new ArrayList<String>();
			//System.out.print("sasss\n");
			for(int i = 0; i < list.size(); i++) {
				
				char[] charArray = list.get(i).toCharArray();
				permute(charArray, 0);
				
				for(int j = 0; j < store.size(); j++) {	
					for(int k = 0; k < list.size(); k++) {	
								
						if(store.get(j).equals(list.get(k))) {
							System.out.print(list.get(k) + " ");
							list.remove(k);
							k--;
						}
					}								
					
				}
				System.out.print("\n");		
				
			}
		}
		
		System.out.print(list.get(0) + "\n");		
		//System.out.print(Arrays.toString(list.toArray()) + "\n");		
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		group_anagram G = new group_anagram();
		list.add("eat");
		list.add("tea");
		list.add("tan");
		list.add("ate");
		list.add("nat");
		list.add("bat");
		
		G.find_anagram(list);
	}
}
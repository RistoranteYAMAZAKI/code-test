import java.util.*;

public class myatoi {


    public static void my_atoi(String s) {  
		
		int dot_check = 0;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		//System.out.print(Character.getNumericValue(s.charAt(0)) + "\n");
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.getNumericValue(s.charAt(i)) >= 0 && Character.getNumericValue(s.charAt(i)) <= 9 || s.charAt(i) == '.') {
				continue;
			}			
			else {
				System.out.print("0" + "\n");
				return;				
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.getNumericValue(s.charAt(i)) >= 0 && Character.getNumericValue(s.charAt(i)) <= 9) {
				tmp.add(Character.getNumericValue(s.charAt(i)));
				//System.out.print(s.charAt(i) + "\n");
			}
			else{
				
				if(tmp.size() == 0) {
					System.out.print("0" + "\n");
					return;
				}
				else {
					for(int j = 0; j < tmp.size(); j++) {
						System.out.print(tmp.get(j));
					}
					System.out.print("\n");
					return;
				}
				
			}
		}
		
		for(int j = 0; j < tmp.size(); j++) {
			System.out.print(tmp.get(j));
		}		
		System.out.print("\n");
    }

	public static void main(String[] args) {
		
		String str = "5.4321+33=?";
		//System.out.print(str.charAt(0) + "\n");
		my_atoi(str);
	}


}
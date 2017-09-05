import java.util.*;

public class mini_parse {
	
	public void parser(String s) {
		
		ArrayList<String> store = new ArrayList<String>();
		String tmp = "";
		int first = 0;
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '[' || s.charAt(i) == ']' || s.charAt(i) == ',') {
				if(first == 0) {
					first++;
					continue;
				}
				store.add(tmp);
				tmp = "";
				continue;
			}
			else {
				tmp = tmp + s.charAt(i);
			}
		}
		
		for(int i = 0; i < store.size(); i++) {
			System.out.print(store.get(i) + "\n");
		}
		System.out.print("aaa\n");
		
	}
	
	public static void main(String[] args) {
		
		mini_parse Parse = new mini_parse();
		String str = "[123,[456,[789]]]";
		Parse.parser(str);
	}
}

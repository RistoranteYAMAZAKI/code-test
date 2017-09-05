import java.util.*;

public class char_freq {
	
	public void find_sort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
			else {
				map.put(s.charAt(i),1);
			}
		}
		/*
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		*/
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
			public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
					return entry2.getValue().compareTo(entry1.getValue());
			}
		});
		
		String str = "";
		for(Map.Entry<Character, Integer> entry : list) {
			int count = 0;
			while(count != entry.getValue()) {
				str = str + entry.getKey();
				count++;
			}
			//System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		char_freq c = new char_freq();
		String s = "Aaaabb";
		c.find_sort(s);
	}
}
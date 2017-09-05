import java.util.*;

public class word_break {
	
	public void permute(String[] input2, int startindex, String s) {
		
		String s_tmp = "";
		if(input2.length == startindex) {
			for(int i = 0; i < input2.length; i++) {
				s_tmp = s_tmp + input2[i] + " ";
				//System.out.print(input2[i] + " ");
			}
				
			if((s_tmp.replaceAll(" ", "")).equals(s)) {
				System.out.print(s_tmp + "\n");
			}
		}
		else {
			for(int i = startindex; i < input2.length; i++) {
				String[] input = input2.clone();
				String tmp = input[i];
				input[i] = input[startindex];
				input[startindex] = tmp;
				permute(input, startindex+1, s);
			}
		}
	}
	
	
    public void wordBreak(String s, List<String> wordDict) {
        
		word_break w = new word_break();
		List<String> tmp = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		int count = 0;
		
		while(count != wordDict.size()) {
			count++;
			
			String str = s;
			//System.out.print(str + "\n");
			for(int i = 0; i < wordDict.size(); i++) {
				if(str.contains(wordDict.get(i))) {
					int start = str.indexOf(wordDict.get(i));
					int l = wordDict.get(i).length();
					if(start == 0) {
						tmp.add(wordDict.get(i));
						//System.out.print(wordDict.get(i) + "\n");
						str = str.substring(start+l, str.length());
						//System.out.print(str + "\n");
					}
					else if(start == -1) {
						continue;
					}
					else {
						tmp.add(wordDict.get(i));
						//System.out.print(wordDict.get(i) + "\n");
						str = str.substring(0, start) + str.substring(start+l, str.length());
						//System.out.print(str + "\n");
					}
				}
				else {
					continue;
				}
				
			}
			//System.out.print(str + "\n");
			
			if(str.length() == 0){
				String str2 = "";
				for(int i = 0; i < tmp.size(); i++) {
					str2 = str2 + tmp.get(i);
				}
				//list to array
				String[] ARR = new String[tmp.size()];
				ARR = tmp.toArray(ARR);
				w.permute(ARR, 0, s);
				//System.out.print(count + "\n");
				//System.out.print(str2 + "\n");
				result.add(str2);
			}
			else {
				//System.out.print(count + "\n");
				tmp.clear();
			}
			//System.out.print("-------------" + "\n");
			wordDict.add(wordDict.get(0));
			wordDict.remove(0);
			
		}		
    }	
	
	public static void main(String[] args) {
		
		word_break w = new word_break();
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		/*  String to string array
		String[] ary = "abc".split("");
		for(int i = 1; i < ary.length; i++) {
			System.out.print( ary[i] + "\n");
		}
		*/
		// String to charArray
		// String str = "aaaaa"
		// char[] arr = str.toCharArray();
		w.wordBreak(s, wordDict);
		
		
	}
}
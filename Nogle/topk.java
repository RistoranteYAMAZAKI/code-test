import java.util.*;

public class topk {
	
	public void find_topk(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		//Count and Save
        for(int n: nums){
			if(map.containsKey(n)) {
				map.put(n, map.get(n)+1);
			}
			else {
				map.put(n, 1);
			}
        }
		//System.out.print(map.entrySet() + "\n");
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " : " +entry.getValue() + "\n");
		}
		
		//Sort 
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> entry1,
                               Map.Entry<Integer, Integer> entry2){
                return (entry2.getValue() - entry1.getValue());
            }
        });
		
        for (Map.Entry<Integer, Integer> entry : list) {
            
			System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
		
	
		int k_check = 0, k_last = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            k_check++;
			if(k_check <= k) {
				System.out.println(entry.getKey() + "\t" + entry.getValue());	
				k_last = entry.getValue();
			}
			else {
				if(entry.getValue() == k_last) {
					System.out.println(entry.getKey() + "\t" + entry.getValue());	
				}
				else {
					break;
				}
			}
        }

		
	}
	
	public static void main(String[] args) {
		
		topk tk = new topk();
		int[] nums = {1,1,1,2,2,3,4,5,5,5,5,5,6,6,6};
		tk.find_topk(nums, 2);
	}
	
}

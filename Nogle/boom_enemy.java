import java.util.*;

public class boom_enemy {
	
	public static int find_max_enemy(String[][] arr) {
		int max = 0, count = 0, x = 0, y = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j].equals("W")) {
					continue;
				}
				else {
					
					//origin
					if(arr[i][j].equals("E")) 
						count++;
					
					//up
					x = i;
					while(x >= 0) {
						x--;
						if(x < 0 || arr[x][j].equals("W"))
							break;
						if(arr[x][j].equals("E"))
							count++;
					}
					//down
					x = i;
					while(x < arr.length) {
						x++;
						//System.out.println(x + " " + j);
						if(x == arr.length || arr[x][j].equals("W")){
							break;
						}
						if(arr[x][j].equals("E"))
							count++;
					}
					//left
					y = j;
					while(y >= 0) {
						y--;
						if(y < 0 || arr[i][y].equals("W"))
							break;
						if(arr[i][y].equals("E"))
							count++;
					}
					//right
					y = j;
					while(j < arr[0].length) {
						y++;
						if(y == arr[0].length || arr[i][y].equals("W"))
							break;
						if(arr[i][y].equals("E"))
							count++;
					}					
					
				}
				if(count > max)
					max = count;
				count = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		String[][] arr = { {"0","E","0","0"},
					       {"E","0","W","E"},
					       {"0","E","0","0"},
						   {"0","W","0","0"},
						   {"0","E","0","0"}};
		
		System.out.println(find_max_enemy(arr));

		
	}
}
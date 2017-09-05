import java.util.*;

public class max_square {
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,1,1,0,0},
						{1,1,1,1,1},
						{1,1,1,1,1},
						{1,0,0,1,0}};
						
		//System.out.print(arr.length + " " + arr[0].length); //4, 5
		int m = arr.length, n = arr[0].length, result = 0;
		int[][] store = new int[m+1][n+1];
		
		for (int i = 1 ; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(arr[i-1][j-1] == 1){
					store[i][j] = Math.min(Math.min(store[i][j-1], store[i-1][j-1]), store[i-1][j]) + 1;
					result = Math.max(store[i][j], result);
				}
			}
		}
		
		System.out.print("result is : " + result*result + "\n"); 
		
		
		String str = "testString";
		char[] charArray = str.toCharArray();
		for(int i = 0; i < charArray.length; i++){
			System.out.print(charArray[i] + " "); 
		}
	}		
}
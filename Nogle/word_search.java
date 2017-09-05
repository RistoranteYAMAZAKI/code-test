import java.util.*;

public class word_search {

	static boolean visited[][]; 
    public static boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if( (word.charAt(0) == board[i][j]) && find(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
    }
	
    public static boolean find(char[][] board, String word, int x, int y, int index) {
		
		if(index == word.length()) {
			return true;
		}
		
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(index) != board[x][y] || visited[x][y]) {
			return false;
		}
		
		visited[x][y] = true;
		if(find(board, word, x-1, y, index+1) ||
		   find(board, word, x+1, y, index+1) ||
		   find(board, word, x, y-1, index+1) ||
		   find(board, word, x, y+1, index+1)) {
			return true;
		}
		visited[x][y] = false;
		return false;
		
    }	
	
	public static void main(String[] args){
		
		char[][] arr = {{'A','B','C','E'},
						{'S','F','C','S'},
						{'A','D','E','E'}};
		String word = "SEE";				
		System.out.println(exist(arr, word));
		
	}
  

}
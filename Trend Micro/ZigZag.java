import java.util.*;

public class ZigZag {


    public static void convert(String s, int nRows) {  
		
		int l = s.length();
		int down = 0;
		int up = 0;
		int tmp = l / (nRows+nRows-1);
		int array_col = nRows * (tmp+1);
		
		int index_1 = 0, index_2 = 0;
		
		char[][] array = new char[nRows][array_col];
		array[index_1][index_2] = s.charAt(0);
		
		for(int i = 1; i < l; i++) {
			//System.out.print(s.charAt(i) + "\n");
			if(down != nRows-1) {
				index_1 = index_1 + 1;
				array[index_1][index_2] = s.charAt(i);				
				down++;
			}
			else{
				if(up != nRows-1) {
					index_1 = index_1 - 1;
					index_2 = index_2 + 1;
					array[index_1][index_2] = s.charAt(i);
					up++;
					if(up == nRows-1){
						down = 0;
						up = 0;
					}
				}


			}

		}
		//check first step 
		String result = "";
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < array_col; j++) {
				result = result + array[i][j];
			}
			//System.out.print("\n");
		}
		System.out.print(result + "\n");
    }

	public static void main(String[] args) {
		
		String str = "PAYPALISHIRING";
		//System.out.print(str.charAt(0) + "\n");
		convert(str, 4);
	}


}
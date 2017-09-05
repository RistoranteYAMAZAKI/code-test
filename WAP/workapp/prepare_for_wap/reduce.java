import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class reduce {


	public static void main(String[] args) {

		// 0 < m <= n , 0 < a < m , m <= b <= n
		//output a/b > reduce, not-reduce

		int m = 0;
		int n = 0;		

		Scanner in = new Scanner(System.in);
		
        m = in.nextInt();
        n = in.nextInt();			
		//System.out.println(m + " " + n);
		
		int r = 0;
		int large = 0;
		int small = 0;
		
		for(int i = 1; i < m; i++){
			
			for(int j = m; j <=n; j++){
				
				large = j;
				small = i;
				r = large%small;
				
				while(r != 0){
					
					large = small;
					small = r;
					r = large%small;
					
					
					
				}				
				
				if(small == 1){
					System.out.println("unreduce" + i + "/" + j);
				}
				else{
					System.out.println("reduce" + i + "/" + j);
				}
				
			}
			
			
		}
		
		
	}
	

}
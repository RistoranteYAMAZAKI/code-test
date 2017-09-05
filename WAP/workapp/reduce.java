import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;

public class reduce {


    public static int findCMD(int a, int b) {  
        int r;  
		
        int aa = a;  
        int bb = b;  
        r = bb % aa;  
		
        while (r!=0) {  

			bb = aa;
			aa = r;
			r = bb % aa;
        }
		
        return aa;  
    }

	public static void main(String[] args) {
		// 0 < m <= n , 0 < a < m , m <= b <= n
		//output a/b > reduce, not-reduce
		
		int m = 6;
		int n = 9;
				
		
		for (int b = m; b < n+1; b++ ){
			
			for(int a = 1; a < m; a++){
				
				if( findCMD(b,a) == 1){
					System.out.print("un-reduce: " + a + "/" + b + "\n");
				}
				else{
					System.out.print("reduce: " + a + "/" + b + "\n");
				}
			
			
			}
			
			
		}
	
	
	}


}
import java.text.DecimalFormat;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.lang.Math;


public class rangen {
	public static void main(String [] argv) throws IOException {
		
					
		//	System.out.println(fileList.get(i)); //印出資料夾內的檔名
		int total = 0;
                
		int status = 0;

		FileReader fr = new FileReader("/home/hdc/aa.txt");
		
		FileWriter fw = new FileWriter("/home/hdc/output.txt");

		BufferedReader br = new BufferedReader(fr);
		
		Set<String> intSet = new HashSet<String>();
		
		while (br.ready()) {
			String s2 = br.readLine();
			//String[] line = s2;
			intSet.add(s2);
		
		}		

		String nonDuplicateArray[] = new String[intSet.size()];
		Object[] tempArray = intSet.toArray();
		for (int j = 0; j < tempArray.length; j++) {
			nonDuplicateArray[j] = (String) tempArray[j];

		}
		
		//String s2 = br.readLine();
		while (1) {
			
			int i = 0;
			i = (int)(Math.random()*(10001))+2000;
			
			int j = 0;
			j = (int)(Math.random()*(200))+1;

			int k = 0;
			k = (int)(Math.random()*2);
			
			int l = 0;
			l = (int)(Math.random()*2);			
			
			int m = 0;
			m = (int)(Math.random()*2);


			
			fw.write(i + "\t" + j + "\t" + k + "\t" + l + "\t" + m + "\t" + nonDuplicateArray[j] +"\n");

			if(total == 50)
				break;
		}
		


        	fw.flush();
        	fw.close();
		fr.close();


	}
}


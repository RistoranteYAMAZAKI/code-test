import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


public class filter {
	public static void main(String [] argv) throws IOException {
		
		
		//	System.out.println(fileList.get(i)); //印出資料夾內的檔名

		FileReader fr = new FileReader("/home/hdc/data_preprocessing/data/abuse_pattern.csv");

		FileWriter fw = new FileWriter("/home/hdc/data_preprocessing/result/abuse.txt");
		
		int first;
		int length;
		int check = 0;
		String s1,s3;
		
		BufferedReader br = new BufferedReader(fr);
		//String s2 = br.readLine();
		while (br.ready()) {
			String s2 = br.readLine();
			s1 = s2;

			String[] line = s1.split(",");

			Set<String> intSet = new HashSet<String>();
			for (String element : line) {
			    intSet.add(element);
			}

			// intSet.size() 為不重複項目的個數
			String nonDuplicateArray[] = new String[intSet.size()];
			Object[] tempArray = intSet.toArray();
			for (int j = 0; j < tempArray.length; j++) {
			    nonDuplicateArray[j] = (String) tempArray[j];

                                 if(j == (tempArray.length-1) ){
					fw.write(nonDuplicateArray[j] + "\n");
                                        continue;
                                }
			    fw.write(nonDuplicateArray[j] + " ");
			}
		 	
		//	fw.write("\n");

			//fw.write(s1.substring(first, length) + "\n");	
		}

		//FileWriter fw = new FileWriter("test.txt");
        	//fw.write("test");
        	fw.flush();
        	fw.close();
		fr.close();
	               
		


	}
}



import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


public class PAKDD {
	public static void main(String [] argv) throws IOException {
		
		
		//	System.out.println(fileList.get(i)); //印出資料夾內的檔名

		FileReader fr = new FileReader("/home/hdc/data_preprocessing/data/trainingData.csv");

		FileWriter fw = new FileWriter("/home/hdc/data_preprocessing/result/trainingData_edit.csv");
		
		int first;
		int length;
		int check = 0;
		int pre;
		String s1,s3;
		
		BufferedReader br = new BufferedReader(fr);
		//String s2 = br.readLine();
		while (br.ready()) {
			String s2 = br.readLine();
			s1 = s2;
			//length = s2.length();
			//first = s2.indexOf(" ");	
			
			//br.readLine().substring(first, length - 1);
			//fw.write(br.readLine().substring(3, 6) + "\n");
		       
			//s3 = s1.substring(first, length);
			String[] line = s1.split(",");
			
			pre = line.length;
			String[] product = line[pre-1].split(";");
			check = product.length;
			
			if(check == 1){
				for (int j = 0; j < line.length; j++) {
					
						if(j == (line.length-1) ){						
							fw.write(line[j] + "," + check + "\n");
							continue;
						}
						fw.write(line[j] + ",");

				}
		 	}
			else{
				for (int k = 0; k < product.length; k++){
					fw.write(line[0] + "," + line[1] + "," + line[2] + "," + product[k] + "," + check + "\n");
				}
			}
			
		}
        	fw.flush();
        	fw.close();
		fr.close();

	}
}

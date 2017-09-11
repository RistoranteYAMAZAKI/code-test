import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


public class split {
	public static void main(String [] argv) throws IOException {
		
					
		//	System.out.println(fileList.get(i)); //印出資料夾內的檔名

		FileReader fr = new FileReader("/home/hdc/chihsuan/no_abuse_pattern.csv");

		FileWriter fw = new FileWriter("/home/hdc/chihsuan/no_abuse_pattern.csv_edit");

		BufferedReader br = new BufferedReader(fr);
		//String s2 = br.readLine();
		while (br.ready()) {
			String s2 = br.readLine().replace(',', ' ');
			fw.write(s2 + "\n");

			//fw.write(s1.substring(first, length) + "\n");	
		}

		//FileWriter fw = new FileWriter("test.txt");
        	//fw.write("test");
        	fw.flush();
        	fw.close();
		fr.close();
	                //System.out.println("job " + i + " complete! \n");	
		


	}
}


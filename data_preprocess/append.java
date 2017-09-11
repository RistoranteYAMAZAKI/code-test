import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


public class append {
	public static void main(String [] argv) throws IOException {
		
		
		File f = new File("00"); //讀取"00這個資料夾"，要記得將此資料夾放置同個java file裡面
		ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名

		if(f.isDirectory()){
	 
			System.out.println("filename : "+f.getName()); //印出我們所讀到的資料夾
			String []s=f.list(); //宣告一個list
			System.out.println("size : "+s.length); //印出資料夾裡的檔案個數
				for(int i=0;i<s.length;i++){
					//System.out.println(s[i]);
					fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
				}
		}
		
		for(int i=0;i<fileList.size();i++){
			
			
		//	System.out.println(fileList.get(i)); //印出資料夾內的檔名

		FileReader fr = new FileReader("/home/hdc/data_preprocessing/00/" + fileList.get(i));

	     FileWriter fw = new FileWriter("/home/hdc/data_preprocessing/output/micro.txt", true);	
		
		BufferedReader br = new BufferedReader(fr);
		//String s2 = br.readLine();
		while (br.ready()) {
			String s2 = br.readLine();
			fw.write(s2 + "\n");
		}


        	fw.flush();
        	fw.close();
		fr.close();
	                System.out.println("job " + i + " complete! \n");	
		}


	}
}



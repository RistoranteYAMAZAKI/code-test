import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;

public class queue {



	public static void main(String[] args) {
		
		
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("a");
		myList.add("b");
		myList.add("c");
		myList.add("d");
		myList.add("e");
		myList.add("f");
		
		for (int i = 0; i < myList.size(); i++ ){
				
			System.out.print(myList.get(i) + "\n");
			
		}
		
		for (int i = (myList.size()-1); i >= 0; i-- ){
				
			System.out.print(myList.get(i) + "\n");
			
		}		
	
	
	}


}
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.math.BigDecimal;  

public class dengue_result_miss_correct_rate {
	
	public static double sub(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.subtract(bd2).doubleValue(); 
    } 

	public static int comp(double val1, double val2) {  
	 
		BigDecimal data1 = new BigDecimal(val1);  
		BigDecimal data2 = new BigDecimal(val2); 

		return data1.compareTo(data2);  
	}  
	
	public static void main(String [] argv) throws IOException {
		
					
		//	System.out.println(fileList.get(i)); //

		FileReader fr = new FileReader("/home/hdc/data_preprocessing/compare.txt");
		FileWriter fw = new FileWriter("/home/hdc/data_preprocessing/compare_result.txt");

		FileWriter fwr = new FileWriter("/home/hdc/data_preprocessing/mis_rise.txt");
		FileWriter fwd = new FileWriter("/home/hdc/data_preprocessing/mis_down.txt");
		
		int first_line = 0;	
		int data_first = 0;
		int data_second = 0;
		double b3 = 0.00;
		double b4 = 0.00;
		double b5 = 0.00;
		double b6 = 0.00;	
		double b7 = 0.00;	
		double b8 = 0.00;	
		double b9 = 0.00;	
		
		double check = 1.00;
		double check2 = 0.00;
		
		double baseline_h = 2.00;
		double baseline_l = 0.55;
		
		int rise_correct = 0;
		int rise_fail = 0;
		int down_correct = 0;
		int down_fail = 0;
		int eq_correct = 0;
		int eq_fail = 0;
		
		int else_condition = 0 ;
		
		int total_correct = 0;
		int total_fail = 0;
		
		String time1 = new String();
		
		BufferedReader br = new BufferedReader(fr);
		
		String[] predict_pre_week = new String[5538]; 
		String[] predict_week = new String[5538];  
		String[] test_week = new String[5538];  
		
		while (br.ready()) {
			/*
		    if(first_line == 0){
				String s11 = br.readLine();
				predict_pre_week = s11.split("\t"); //doesn't use
							
				first_line++;
				continue;
			}		
			*/
			if(data_first == 0){
				String s2 = br.readLine();

				predict_week = s2.split("\t");	 // predict next week line
				data_first++;
				continue;
			}
			/*
			if(data_second == 0){
				String s5 = br.readLine();

				test_week = s5.split("\t");		//doesn't use
				data_second++;
				continue;
			}
			*/
			String s3 = br.readLine();
			
			String[] real = s3.split("\t");    //real next week line
			

			
			for (int j = 0; j < real.length; j++) {
			
			//Double.parseDouble(predict_this_week).subtract(Double.parseDouble(predict_pre_week)).doubleValue() 
			
			//Double.parseDouble(predict_this_week)
			//Double.parseDouble(predict_pre_week)
			
				//((Double.parseDouble(predict_week[j])).subtract(Double.parseDouble(predict_pre_week[j])).doubleValue()).compareTo(check) > 0
				if( comp( Double.parseDouble(predict_week[j]), check )  > 0 ){
					
					
					//((Double.parseDouble(real[j])).subtract(Double.parseDouble(test_week[j])).doubleValue()).compareTo(check) > 0
					if( comp( Double.parseDouble(real[j]), check ) > 0 ){
						
						//b3 = Math.round(b2*100)/100.0;	
						//((Double.parseDouble(predict_week[j])).subtract(Double.parseDouble(predict_pre_week[j])).doubleValue())
						b3 = Math.round( Double.parseDouble(predict_week[j])*100 )/100.0;									
						
						//((Double.parseDouble(real[j])).subtract(Double.parseDouble(test_week[j])).doubleValue())
						b4 = Math.round( Double.parseDouble(real[j])*100 )/100.0;									
						rise_correct++;
						fw.write("predict rise correct" + "\t" + " predict percentage: " + b3 + "\t" + " real percentage: " + b4 + "\n");
					}
					else if( comp( Double.parseDouble(real[j]), check ) < 0 && comp( Double.parseDouble(real[j]), check2 ) >= 0 ){
					
						b3 = Math.round( Double.parseDouble(predict_week[j])*100 )/100.0;									
						b4 = Math.round( Double.parseDouble(real[j])*100 )/100.0;									
						rise_fail++;
						fwr.write("predict rise fail" + "\t" + " predict percentage: " + b3 + "\t" + " real percentage: " + b4 + "\n");				
					
					}
					else{  // equal to 1
						else_condition++;
						continue;
					}
					
				}				
				else if( comp( Double.parseDouble(predict_week[j]), check )  < 0 && comp( Double.parseDouble(predict_week[j]), check2 )  >= 0){
				// present predict down	
					// present real is rise
					if( comp( Double.parseDouble(real[j]), check ) > 0 ){
						
						//b3 = Math.round(b2*100)/100.0;	
						b3 = Math.round( Double.parseDouble(predict_week[j])*100 )/100.0;									
						b4 = Math.round( Double.parseDouble(real[j])*100 )/100.0;											
						down_fail++;
						fwd.write("predict down fail" + "\t" + " predict percentage: " + b3 + "\t" + " real percentage: " + b4 + "\n");
						
					}
					else if( comp( Double.parseDouble(real[j]), check ) < 0 && comp( Double.parseDouble(real[j]), check2 ) >= 0 ){ // include real equal to 0
					// present real is down
						b3 = Math.round( Double.parseDouble(predict_week[j])*100 )/100.0;									
						b4 = Math.round( Double.parseDouble(real[j])*100 )/100.0;										
						down_correct++;
						fw.write("predict down correct" + "\t" + " predict percentage: " + b3 + "\t" + " real percentage: " + b4 + "\n");				
					
					}
					else{  // real equal to 1, present unchange rate with next week and this week
						else_condition++;
						continue;						
						//present miss rate in range
						
						
					}					
					
				}
				else{ // present predict next week is "zero case" & unchange, comp (predict_week[j] , check2) == 0
					
						else_condition++;
						continue;	
				}
				
			
				
			}
				
			total_correct = rise_correct + down_correct;
			total_fail = rise_fail + down_fail;
			int T1 = 0;
			int T2 = 0;
			T1 = total_correct + total_fail + else_condition;
			T2 = total_correct + total_fail;
			
			b5 = Math.round( total_correct*100 )/100.0;									
			b6 = Math.round( total_fail*100 )/100.0;		
			b7 = Math.round( T1*100 )/100.0;
			b8 = Math.round( T2*100 )/100.0;
			
			fw.write("Correct: " + total_correct + " , Fail: " + total_fail + " , Else condition: " + else_condition +"\n");	
			fw.write("Correct percentage: " + (b5/b8) +"\n");	
	
		}

		//FileWriter fw = new FileWriter("test.txt");
        	//fw.write("test");
			fwr.flush();
        	fwr.close();
			fwd.flush();
        	fwd.close();
			
        	fw.flush();
        	fw.close();
		fr.close();
	                //System.out.println("job " + i + " complete! \n");	
		


	}
}



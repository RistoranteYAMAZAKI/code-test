import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedInputStream;

class GetInputFromUser
{
   public static void main(String args[])
   {

   
    Scanner in = new Scanner(System.in);

	//ArrayList<String> temp = new ArrayList<String>();

        int n = 0;
        int m = 0;
        
        //System.out.printf("%d %d\n",n,m);
        n = in.nextInt();
        m = in.nextInt();		
		
		ArrayList<String> input_line = new ArrayList<String>();
		
		for(int i = 0; i < n+m; i++){
			input_line.add(in.nextLine());
		}   
		
		System.out.println("\naaaaaa");
		
		for(int i = 0; i < input_line.size(); i++){
			System.out.println(input_line.get(i));
		}
		
		System.out.println(input_line.size());
		System.out.println(input_line.get(0));
		System.out.println(input_line.get(1));
		System.out.println(input_line.get(9));
		
		System.out.println("\n");
	
    //temp.add(in.nextLine()); //consuming the <enter> from input above
    

	
	//while (in.hasNext()) {
	//	if(in.nextLine() == null || in.nextLine() == "") 
	//		break;
		
	//	System.out.println(in.nextLine());
	//}
	
	
    //for (int i = 0; i < input.length; i++) {
    //    input[i] = in.nextLine();
    //}

    //System.out.printf("\nYour input:\n");
    //for (int i = 0; i < temp.size(); i++) {
    //    System.out.printf(temp.get(i) + "\n");
    //}
	
	
 

   }
}
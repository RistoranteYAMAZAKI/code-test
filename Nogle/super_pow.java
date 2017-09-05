import java.util.*;

public class super_pow {
	
	public void pow(int a, int[] b) {
		String str = "";
		for(int i = 0; i < b.length; i++) {
			str = str + b[i];
		}
		int pow = Integer.parseInt(str);
		
		long init = 1L;
		while(pow != 0) {
			init = init * a;
			pow--;
		}
		
		System.out.println(init % 1337);
	}
	
	public static void main(String[] args) {
		
		int a = 2;
		int[] nums = {1,3};

		super_pow sp = new super_pow();
		sp.pow(a, nums);

	}
}
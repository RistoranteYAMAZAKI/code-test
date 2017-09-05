import java.util.*;

public class reverse {

	public static int rev(int x)
	{
		int result = 0;

		while (x != 0)
		{
			int tail = x % 10;
			int newResult = result * 10 + tail;
			System.out.print(newResult + "\n");
			if ((newResult - tail) / 10 != result) //deal with overflow
			{ return 0; }
			result = newResult;
			x = x / 10;
		}

		return result;
	}

	public static void main(String[] args) {
		
		int number = 2147483647;
		System.out.print(rev(number) + "\n");
		
	}
}
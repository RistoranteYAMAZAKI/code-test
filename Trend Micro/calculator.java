import java.util.*;

public class calculator {

	public static int calculate(String str) {
		char[] s = str.toCharArray();
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> nums = new Stack<Integer>();
        for (int i = 0; i < s.length; ++i) {
            if (s[i] >= '0') {
                d = d * 10 + s[i] - '0';
            }
            if ((s[i] < '0' && s[i] != ' ') || i == s.length - 1) {
                if (sign == '+') nums.push(d);
                if (sign == '-') nums.push(-d);
                if (sign == '*' || sign == '/') {
                    int tmp = 0;
					if(sign == '*') {
						tmp = nums.peek() * d;
					}
					else {
						tmp = nums.peek() / d;
					}
                    nums.pop();
                    nums.push(tmp);
                }
                sign = s[i];
                d = 0;
            } 
        }
        while (!nums.empty()) {
            res += nums.peek();
            nums.pop();
        }
        return res;
	}
	
	public static void main(String[] args) {
		String s = "2+3/ 6* 7 + 5 ";
		int num = calculate(s);
		System.out.print(num + "\n");
	}
	
}
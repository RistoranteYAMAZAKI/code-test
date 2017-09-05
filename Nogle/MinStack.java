import java.util.*;

public class MinStack {
	
	public static Stack<Integer> stack;
	int min = Integer.MAX_VALUE; //Integer.MIN_VALUE
	
	public MinStack() {
		stack = new Stack<Integer>();
	} 
	
	public void push(int x) {
		if(stack.empty()) {
			stack.push(x);
			min = x;
		}
		else {
			if(x < min) {
				stack.push(x);
				min = x;
			}
			else {
				stack.push(min);
			}
		}
	}
	
	public void pop() {
		if(stack.empty()) {
			System.out.println("Empty");
		}
		else {
			stack.pop();
		}
	}
	
	public int getMin() {
		return stack.peek();
	}
	
	public static void main(String[] args) {
		
		MinStack minStack = new MinStack();
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.push(-2);
		System.out.println(minStack.getMin());
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		System.out.println(stack.size());
		System.out.println();
		
		minStack.pop();
		System.out.println(minStack.getMin());  
		minStack.pop();
		System.out.println(minStack.getMin()); 
	}
}
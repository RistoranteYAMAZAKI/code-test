import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class PermuteArray {

	public static void permute(char[] input2, int startindex) {

		if (input2.length == startindex) {
			 displayArray(input2);
		} else {
			for (int i = startindex; i < input2.length; i++) {
				char[] input = input2.clone();
				char temp = input[i];
				input[i] = input[startindex];
				input[startindex] = temp;
				permute(input, startindex + 1);
			}
		}
	}


	private static void displayArray(char[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ";  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		char[] input = { '1', '1', '2'};
		permute(input, 0);
	}


}
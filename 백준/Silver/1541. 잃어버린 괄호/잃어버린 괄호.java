import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		
		String[] arr = s.split("-");
		
		for (int i = 0; i < arr.length; i++) {
			int temp = mySum(arr[i]);
			
			if (i == 0)
				answer = answer + temp;
			else 
				answer = answer - temp;
		}
		
		System.out.println(answer);
		
	}
	
	static int mySum(String a) {
		int sum = 0;
		// + 가 의미를 가지는 메타 문자이므로, [] 해야 문자로 인식함
		String[] temp = a.split("[+]");
		
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		
		return sum;
	}
}
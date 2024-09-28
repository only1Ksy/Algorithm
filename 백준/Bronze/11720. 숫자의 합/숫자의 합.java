import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		input.nextLine();
		
		String a = input.next();
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += a.charAt(i) - '0';
		}
		
		System.out.println(sum);
		
	}
}
import java.util.*;

public class Main {
	
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static final int INT_MIN = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int max = INT_MIN;
		int min = INT_MAX;
		
		for (int i = 0; i < n; i++) {
			int a = input.nextInt();
			
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		
		System.out.println(min + " " + max);
		
	}

}

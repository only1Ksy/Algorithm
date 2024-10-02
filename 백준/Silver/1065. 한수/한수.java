import java.util.*;

public class Main {
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static final int INT_MIN = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			boolean isTrue = true;
			
			String s = i + "";
			
			int temp = s.length() == 1 || s.length() == 2 ? 0 : s.charAt(1) - s.charAt(0);
			
			for (int j = 2; j < s.length(); j++) {
				if (s.charAt(j) - s.charAt(j-1) == temp) continue;
				else {
					isTrue = false;
					break;
				}
			}
			
			if (isTrue) cnt++; 
		}
		
		System.out.println(cnt);
		
	}

}

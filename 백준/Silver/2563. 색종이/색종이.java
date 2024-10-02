
import java.util.*;

public class Main {
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static final int INT_MIN = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[][] arr = new int[101][101];
		
		int n = input.nextInt();
		
		// 왼쪽 아래 꼭짓점이 주어짐
		for (int i = 0; i < n; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] == 1) sum++;
			}
		}
		
		System.out.println(sum);
	}

}

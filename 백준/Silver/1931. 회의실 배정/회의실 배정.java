import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = input.nextInt();
			arr[i][1] = input.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] s, int[] e) {
				if (s[1] == e[1]) {
					return s[0] - e[0];
				} return s[1] - e[1];
			}
		});
		
		int cnt = 0;
		int end = -1;
		
		for (int i = 0; i < n; i++) {
			if (arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
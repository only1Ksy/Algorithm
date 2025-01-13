import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		parent = new int[n + 1];
		
		// 대표 노드를 자기 자신으로 초기화
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int isConnected = input.nextInt();
				
				if (isConnected == 1) {
					union(i, j);
				}
			}
		}
		
		int[] arr = new int[m+1];
		
		for (int i = 1; i <= m; i++) {
			arr[i] = input.nextInt();
		}
		
		int index = find(arr[1]);
		
		for (int i = 2; i <= m; i++) {
			if (index != find(arr[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 대표 노드가 같지 않으면
		if (a != b) {
			// 같게 설정
			parent[b] = a;
		}
	}
	
	static int find(int a) {
		// a의 대표노드가 자기 자신이라면
		if (a == parent[a])
			return a;
		else 
			// 그렇지 않으면 a의 대표 노드를 찾아가기
			return parent[a] = find(parent[a]);
	}
	
	static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b)
			return true;
		
		return false;
	}
}
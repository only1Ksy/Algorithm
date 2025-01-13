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
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			int which = input.nextInt();
			int a = input.nextInt();
			int b = input.nextInt();
			
			if (which == 0) {
				union(a, b);
			} else {
				if (checkSame(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
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
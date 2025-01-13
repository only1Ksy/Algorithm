import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;
	public static int[] trueP;
	public static ArrayList<Integer>[] party;
	public static int result;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		int t = input.nextInt(); // 진실을 아는 사람의 수
		result = 0;
		trueP = new int[t];
		
		// 진실을 아는 사람 저장
		for (int i = 0; i < t; i++) {
			trueP[i] = input.nextInt();
		}
		
		party = new ArrayList[m];
		
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<Integer>();
			
			int partySize = input.nextInt();
			
			for (int j = 0; j < partySize; j++) {
				party[i].add(input.nextInt());
			}
		}
		
		parent = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		
		// 파티에 간 사람들 대표 노드 설정해서 그룹화
		for (int i = 0; i < m; i++) {
			// 각 파티의 첫 번째 사람을 대표노드로 만들기
			int firstPeople = party[i].get(0);
			
			for (int j = 1; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// 각 파티 대표노드와 진실사람 대표노드가 같으면 과장 불가능
		for (int i = 0; i < m; i++) {
			boolean isPossible = true;
			
			// 각 파티의 대표노드는 첫 번째 사람
			int cur = party[i].get(0);
			
			// 각 파티의 대표노드가 trueP 중 어떤 한 값이라도 겹치면 false
			for (int j = 0; j < trueP.length; j++) {
				if (find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			
			if (isPossible) result++;
		}
		
		System.out.println(result);
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
import java.util.*;
import java.io.*;

public class Main {
	static int visited[];
	static ArrayList<Integer>[] A;
	static int n, m, k, x;
	static List<Integer> answer;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		x = input.nextInt();
		A = new ArrayList[n+1];
		answer = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int s = input.nextInt();
			int e = input.nextInt();
			A[s].add(e);
		}
		
		visited = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			visited[i] = -1;
		}
		BFS(x);
		
		for (int i = 0; i <= n; i++) {
			if (visited[i] == k) {
				answer.add(i);
			}
		}
		
		if (answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
		}
		
		for (int temp: answer) {
			System.out.println(temp);
		}
	}
	
	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node]++;
		
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			
			for (int i : A[now_Node]) {
				if (visited[i] == -1) {
					visited[i] = visited[now_Node] + 1;
					queue.add(i);
				}
			}
		}
	}
	
}
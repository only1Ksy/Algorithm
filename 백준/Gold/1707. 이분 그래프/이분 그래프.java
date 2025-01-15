import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean visited[];
	static boolean isEven;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			
			int v = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			
			A = new ArrayList[v + 1];
			visited = new boolean[v + 1];
			check = new int[v + 1];			
			isEven = true;
			
			for (int j = 1; j <= v; j++) {
				A[j] = new ArrayList<Integer>();
			}
			
			for (int j = 0; j < e; j++) {
				s = br.readLine().split(" ");
				
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				
				A[start].add(end);
				A[end].add(start);
			}
			
			for (int j = 1; j <= v; j++) {
				if (isEven)
					DFS(j);
				else
					break;
			}
			
			if (isEven)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
	
	private static void DFS(int node) {
		visited[node] = true;
		
		for (int i : A[node]) {
			if (!visited[i]) {
				check[i] = (check[node] + 1) % 2;
				DFS(i);
			}
			
			else if (check[node] == check[i]) {
				isEven = false;
			}
		}
	}
	
	/* private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			
			for (int i : A[now_Node]) {
				if (visited[i] == false) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
		}
	} */
	
}
import java.util.*;
import java.io.*;

public class Main {
	public static ArrayList<ArrayList<Node>> A;
	public static int[] distance;
	public static boolean[] visited;
	public static PriorityQueue<Node> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = input.nextInt();
		int E = input.nextInt();
		int K = input.nextInt();
		
		A = new ArrayList<>();
		
		for (int i = 0; i <= V; i++) {
			A.add(new ArrayList<>());
		}
		
		// 그래프 초기화
		for (int i = 0; i < E; i++) {
			int u = input.nextInt();
			int v = input.nextInt();
			int w = input.nextInt();
			
			A.get(u).add(new Node(v, w));
		}
		
		// 거리 배열, 방문 배열 초기화
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(visited, false);
		Arrays.fill(distance, 99999999);
		
		distance[K] = 0;
		//visited[K] = true;
		queue.add(new Node(K, 0));
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			
			int nowNode = now.node;
			
			if (visited[nowNode]) continue; // 방문한 적 있으면 건너뛰기
			visited[nowNode] = true;
			
			// 현재 노드와 연결되어 있는 모든 노드에 대해
			for (int i = 0; i < A.get(nowNode).size(); i++) {
				Node tmp = A.get(nowNode).get(i);
				
				int next = tmp.node;
				int value = tmp.value;
				
				// 현재 거리가 노드를 지나쳐서 가는 거리보다 크면 변경 (따라서 처음엔 무조건 변경)
				if (distance[next] > distance[nowNode] + value) {
					distance[next] = distance[nowNode] + value;
					queue.add(new Node(next, distance[next]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (visited[i])
				System.out.println(distance[i]);
			else 
				System.out.println("INF");
		}
		
	}
}

class Node implements Comparable<Node>{
	int node;
	int value;
	
	public Node (int node, int value) {
		this.value = value;
		this.node = node;
	}
	
	// 노드의 엣지 값에 따라 오름차순으로 queue 삽입됨
	public int compareTo(Node n) {
		if (this.value > n.value) return 1;
		else return -1;
	}
}

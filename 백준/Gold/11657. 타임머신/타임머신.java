import java.util.*;
import java.io.*;

public class Main {
	public static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		Edge [] edges = new Edge[M + 1];
		
		for (int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			edges[i] = new Edge(a, b, c);
		}
		
		for (int i = 0; i < N - 1; i++) {
			// 모든 에지에 대해
			for (int j = 0; j < M; j++) {
				if (dist[edges[j].start] != Integer.MAX_VALUE && dist[edges[j].start] + edges[j].cost < dist[edges[j].end]) {
					dist[edges[j].end] = dist[edges[j].start] + edges[j].cost;
				}
			}
		}
		
		boolean isINF = false;
		
		for (int j = 0; j < M; j++) {
			if (dist[edges[j].start] != Integer.MAX_VALUE && dist[edges[j].start] + edges[j].cost < dist[edges[j].end]) {
				dist[edges[j].end] = dist[edges[j].start] + edges[j].cost;
				isINF = true;
			}
		}
		
		if (isINF) System.out.println(-1);
		else {
			for (int i = 2; i < N + 1; i++) {
				System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
			}
		}
	}
}

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int cost;
	
	public Edge (int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	// 노드의 엣지 값에 따라 오름차순으로 queue 삽입됨
	public int compareTo(Edge e) {
		if (this.cost > e.cost) return 1;
		else return -1;
	}
}

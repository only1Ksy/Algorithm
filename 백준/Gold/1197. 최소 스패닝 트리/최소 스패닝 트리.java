import java.util.*;
import java.io.*;

public class Main {
	// union-fine 수행 배열
	public static int[] parent;
	// 최소 신장 트리 수행 에지 리스트
	public static PriorityQueue<Edge> spTree = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// parent 배열 초기화
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		// 에지 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			spTree.add(new Edge(A, B, C));
		}		
		
		int edgeNum = 0;
		int result = 0;
		
		while (edgeNum < V - 1) {
			Edge nowEdge = spTree.poll();
			int start = nowEdge.start;
			int end = nowEdge.end;
			int weight = nowEdge.weight;
			
			if (find(start) != find(end)) {
				union(start, end);
				edgeNum++;
				result += weight;
			}
		}
		
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}
	// find 연산으로 현재 같은 parent가 아니면 사이클 안 생기니까 ㄱㄴ
	public static int find(int a) {		
		// 재귀함수의 중단점 설정
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
		
	}
}

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		// TODO Auto-generated method stub
		// 오름차순 정렬
		return this.weight - e.weight;
	}
}

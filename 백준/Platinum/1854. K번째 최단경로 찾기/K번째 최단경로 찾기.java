import java.util.*;
import java.io.*;

public class Main {
	public static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 그래프 정보 저장용 행렬
		int[][] w = new int[1001][1001];
		
		PriorityQueue<Integer>[] distQ = new PriorityQueue[N + 1];
		Comparator<Integer> cp = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1;
			}
		};
		for (int i = 0; i < N + 1; i++) {
			distQ[i] = new PriorityQueue<Integer>(K, cp);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// a -c-> b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			w[a][b] = c;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		distQ[1].add(0);
		
		while(!pq.isEmpty()) {
			Node u = pq.poll();
			
			for (int i = 1; i <= N; i++) {
				// 만약 연결된 노드가 있으면
				if (w[u.node][i] != 0) {
					// 저장된 경로가 K 개 미만이면
					if (distQ[i].size() < K) {
								// 현재 노드의 값 + 지나는 노드의 값
						distQ[i].add(u.value + w[u.node][i]);
						pq.add(new Node(i, u.value + w[u.node][i]));
					}
					else if (distQ[i].peek() > u.value + w[u.node][i]) {
						distQ[i].poll();
						distQ[i].add(u.value + w[u.node][i]);
						pq.add(new Node(i, u.value + w[u.node][i]));
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (distQ[i].size() == K) {
				bw.write(distQ[i].peek() + "\n");
			} else {
				bw.write(-1 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
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

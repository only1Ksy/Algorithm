import java.util.*;
import java.io.*;

public class Main {
	public static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = input.nextInt();
		int startCity = input.nextInt();
		int endCity = input.nextInt();
		int M = input.nextInt();
		
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MIN_VALUE);
		dist[startCity] = 0;
		Long[] money = new Long[N];
		
		Edge [] edges = new Edge[M];
		// 교통수단 정보 등록
		for (int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			edges[i] = new Edge(a, b, c);
		}
		// 각 도시에서 벌 수 있는 돈 (노드)
		for (int i = 0; i < N; i++) {
			money[i] = input.nextLong();
		}
		
		dist[startCity] = money[startCity];
		
		// 재방문 가능하므로 충분히 큰 숫자만큼 반복
		for (int i = 0; i <= N + 100; i++) {
			// 모든 에지에 대해
			for (int j = 0; j < M; j++) {
				int start = edges[j].start;
				int end = edges[j].end;
				int cost = edges[j].cost;
				
				if (dist[start] == Long.MIN_VALUE) continue;
				// 만약 시작 노드가 양수 사이클에 연결되어 있다면 종료 노드도 업데이트
				else if (dist[start] == Long.MAX_VALUE)
					dist[end] = Long.MAX_VALUE;
								// start 노드 값 + end 노드에서 버는 돈 - 에지 비용 인 경우 업뎃트
				else if (dist[end] < dist[start] + money[end] - cost) {
					dist[end] = dist[start] + money[end] - cost;
					// i 번째 이후로도 계속 더해지는 경우에는 양수 사이클에 연결된 노드
					if (i >= N - 1) dist[end] = Long.MAX_VALUE;
				}
			}
		}
		// MIN_VALUE에서 업데이트가 되지 않았으면 도착이 불가능
		if (dist[endCity] == Long.MIN_VALUE) System.out.println("gg");
		// 양수 사이클에 연결된 경우
		else if (dist[endCity] == Long.MAX_VALUE) System.out.println("Gee");
		else System.out.println(dist[endCity]); // 그 외 
	}
}

class Edge{
	int start;
	int end;
	int cost;
	
	public Edge (int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

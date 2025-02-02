import java.util.*;
import java.io.*;

public class Main {
	public static final int INF = 1000000000;
	public static int[][] dist;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 유저의 수 = Node
		int n = input.nextInt();
		// 친구 관계의 수 = Edge
		int m = input.nextInt();
		
		// 거리 배열 초기화
		dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 1; i <= m; i++) {
			int startP = input.nextInt();
			int endP = input.nextInt();
			// 친구 관계이므로 양방향 저장
			dist[startP][endP] = 1;
			dist[endP][startP] = 1;
		}
		
		// 모든 경유지에 대해
		for (int i = 1; i <= n; i++) {
			// 모든 출발 노드에 대해
			for (int j = 1; j <= n; j++) {
				// 모든 도착 노드에 대해
				for (int k = 1; k <= n; k++) {
					if (dist[j][i] > 0 &&  dist[i][k] > 0) {
						dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
					}
				}
			}
		}
		
		int minPerson = Integer.MAX_VALUE;
		int personNum = 0;
		int [] kevinBacon = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				kevinBacon[i] += dist[i][j];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (minPerson > kevinBacon[i]) {
				minPerson = kevinBacon[i];
				personNum = i;
			}
		}
		
		System.out.println(personNum);
	}
}
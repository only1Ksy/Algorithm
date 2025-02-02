import java.util.*;
import java.io.*;

public class Main {
	public static final int INF = 1000000000;
	public static int[][] dist;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 도시의 개수 = Node
		int n = input.nextInt();
		
		// 거리 배열 초기화
		dist = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = input.nextInt();
			}
		}
		
		// 모든 경유지에 대해
		for (int i = 1; i <= n; i++) {
			// 모든 출발 노드에 대해
			for (int j = 1; j <= n; j++) {
				// 모든 도착 노드에 대해
				for (int k = 1; k <= n; k++) {
					if (dist[j][k] > 0 || (dist[j][i] == 1 &&  dist[i][k] == 1)) {
						dist[j][k] = 1;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(dist[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
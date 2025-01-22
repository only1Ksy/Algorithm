import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 건물의 종류 수
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			A.add(new ArrayList<>());
		}
		
		int[] indegree = new int[n + 1];  // 진입차수
		int[] timeBuild = new int[n + 1]; // 짓는 데 걸리는 시간
		
		// 각 건물을 짓는 데 걸리는 시간, 먼저 지어져야 하는 건물들 번호 
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			timeBuild[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				// 먼저 지어져야 하는 건물
				int preTemp = Integer.parseInt(st.nextToken());
				
				if (preTemp == -1)
					break;
				
				// 먼저 지어져야 하는 건물 -> 나중 으로 연결
				A.get(preTemp).add(i);
				// 나보다 먼저인 것 개수만큼 증가
				indegree[i]++; 
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		int[] result = new int[n+1];
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int next : A.get(now)) {
				indegree[next]--;
				
				// max(현재 노드에 저장된 최대 시간, 이건 노드에 저장된 최대 시간 + 현재 노드의 생산 시간)
				result[next] = Math.max(result[next], result[now] + timeBuild[now]);
				
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.println(result[i] + timeBuild[i]);
		}
	}
}

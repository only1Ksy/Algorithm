import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 건물의 종류 수
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<dNode>> A = new ArrayList<>();
		ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();

		for (int i = 0; i <= n;i++) {
			A.add(new ArrayList<>());
			reverseA.add(new ArrayList<>());
		}
		
		int [] indegree = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			A.get(s).add(new dNode(e, v));
			reverseA.get(e).add(new dNode(s, v));
			
			indegree[e]++;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int startDosi = Integer.parseInt(st.nextToken());
		int endDosi = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(startDosi);
		int[] result = new int[n + 1];
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (dNode next : A.get(now)) {
				indegree[next.targetNode]--;
				
				// max(현재 노드에 저장된 최대 시간, 이건 노드에 저장된 최대 시간 + 현재 노드의 생산 시간)
				result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
				
				if (indegree[next.targetNode] == 0) {
					queue.offer(next.targetNode);
				}
			}
		}
		
		// reverse
		int resultCnt = 0;
		boolean visited[] = new boolean[n + 1];
		
		queue = new LinkedList<>();
		
		queue.offer(endDosi);
		visited[endDosi] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (dNode next : reverseA.get(now)) {
				if (result[next.targetNode] + next.value == result[now]) {
					resultCnt++;
				
					if (visited[next.targetNode] == false) {
						visited[next.targetNode] = true;
						queue.offer(next.targetNode);
					}
				}
			}
		}
		
		System.out.println(result[endDosi]);
		System.out.println(resultCnt);
	}
}

class dNode {
	int targetNode;
	int value;
	
	dNode (int targetNode, int value){
		this.targetNode = targetNode;
		this.value = value;
	}
}
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		
		// 학생 수
		int n = input.nextInt();
		// 키의 비교 횟수
		int m = input.nextInt();
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			A.add(new ArrayList<>());
		}
		
		// 진입 차수 배열
		int[] indegree = new int[n + 1];
		
		// 키를 비교한 두 학생의 번호 a, b
		for (int i = 0; i < m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			
			A.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			
			for (int next : A.get(now)) {
				indegree[next]--; // now에 연결된 다음 요소의 indegree 감소
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}

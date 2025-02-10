import java.util.*;
import java.io.*;

public class Main {
	// 인접 리스트로 트리 구현
	public static ArrayList<Integer>[] A;
	// 노드의 개수 N
	public static int N;
	// DFS/BFS 시 방문 확인용 배열
	public static boolean[] visited;
	// 정답 저장
	public static int[] answer;
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = input.nextInt();
		// 노드 번호는 1부터 시작
		A = new ArrayList[N + 1];
		// 트리 초기화
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		// 나머지 배열 초기화
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		// 노드 정보 저장
		for (int i = 0; i < N - 1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			A[a].add(b);
			A[b].add(a);
		}
		
		// 루트 노드부터 탐색 시작
		DFS(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
		
	}
	
	public static void DFS(int num) {
		visited[num] = true;
		// A에 연결된 모든 노드에 대해 탐색
		for (int i : A[num]) {
			if (!visited[i]) {
				answer[i] = num;
				DFS(i);
			}
		}
	}
	
}
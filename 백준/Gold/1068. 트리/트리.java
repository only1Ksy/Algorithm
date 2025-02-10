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
	// 지울 노드 번호
	public static int delNum;
	// 리프 노드
	public static int leafNum;
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		N = Integer.parseInt(br.readLine());
		// 노드 번호는 1부터 시작
		A = new ArrayList[N];
		// 트리 초기화
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		// 나머지 배열 초기화
		visited = new boolean[N];
		answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 노드 정보 저장 & 루트 노드 저장
		int root = -1;
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
			if (answer[i] == -1) {
				root = i;
			} else {
				A[answer[i]].add(i); 
				A[i].add(answer[i]);
			}
		}
		// 지울 노드 입력
		delNum = Integer.parseInt(br.readLine());
		
		if (root == delNum) {
			System.out.println(0);
			return;
		}
		
		// 루트 노드부터 탐색 시작, 제거 대상 만날 시 탐색 중단
		leafNum = 0;
		DFS(root);
		
		System.out.println(leafNum);		
	}
	
	public static void DFS(int num) {
		visited[num] = true;
		// 자식 노드 개수 세는 변수
		int kidNum = 0;
		// A에 연결된 모든 노드에 대해 탐색
		for (int i : A[num]) {
			if (!visited[i] && i != delNum) {
				kidNum++;
				DFS(i);
			}
		}
		
		if (kidNum == 0) {
			leafNum++;
		}
	}
	
}
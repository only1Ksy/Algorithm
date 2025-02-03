import java.util.*;
import java.io.*;

public class Main {
	// union-fine 수행 배열
	public static int[] parent;
	// 최소 신장 트리 수행 에지 리스트
	public static PriorityQueue<Edge> spTree = new PriorityQueue<>();
	// 가로, 세로
	public static int N;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 컴퓨터의 개수 N
		N = Integer.parseInt(st.nextToken());
		// 연결 정보 저장 배열 선언
		char[][] connected = new char[N][N];
		
		// 연결 정보 입력 (a-z: 1-26, A-Z: 27-52)
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			connected[i] = line.toCharArray();
		}
		
		// parent 배열 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		int sumAll = 0;
		
		// 최소 신장 트리 구하기 위한 edge 정보 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (connected[i][j] == '0') continue;
				
				int weight = convertCharToNumber(connected[i][j]);
				
				sumAll += weight;
				if (i != j)
					spTree.add(new Edge(i, j, weight));
			}
		}
		
		// 최대(변형) 신장 트리 알고리즘 수행
		int edgeNum = 0;
		int result = 0;
		
		// 최소 신장 트리
		while (edgeNum < N - 1) {
			if (spTree.isEmpty()) {
				System.out.println(-1);
				return;
			}
			
			Edge nowEdge = spTree.poll();
			int start = nowEdge.start;
			int end = nowEdge.end;
			int weight = nowEdge.weight;
			
			if (find(start) != find(end)){
				union(start, end);
				edgeNum++;
				result += weight;
			}			
		}
		
		
		System.out.println(sumAll - result);
	}
	
	public static int convertCharToNumber(char ch) {
	    if ('a' <= ch && ch <= 'z') {
	    	// a의 ASCII 값 97
	        return ch - 'a' + 1; // ✅ a-z → 1-26
	    } else if ('A' <= ch && ch <= 'Z') {
	    	// A의 ASCII 값 65
	        return ch - 'A' + 27; // ✅ A-Z → 27-52
	    }
	    return -1; // ❌ 범위 밖의 문자 처리 (예: 특수문자)
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
		return this.weight - e.weight;
	}
}
import java.util.*;
import java.io.*;

public class Main {
	// 4방향 움직이는 용도 배열
	public static int[] dr = {  -1,  0,  1,  0 };
	public static int[] dc = {   0,  1,  0, -1 };
	// union-fine 수행 배열
	public static int[] parent;
	// 최소 신장 트리 수행 에지 리스트
	public static PriorityQueue<Edge> spTree = new PriorityQueue<>();
	// 지도 배열
	public static int[][] map;
	// BFS 수행용 visited 배열
	public static boolean[][] visited;
	// 섬 리스트
	public static ArrayList<ArrayList<int[]>> sumlist;
	// 섬 각각의 땅 리스트
	public static ArrayList<int[]> mlist;
	// 섬 개수
	public static int sumNum;
	// 가로, 세로
	public static int N, M;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = 세로, M = 가로
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 맵 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				// 0은 바다, 1은 땅
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 개수
		sumNum = 1;
		
		sumlist = new ArrayList<>();
		
		// 섬 분리 작업 수행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && visited[i][j] != true) {
					BFS(i, j);
					sumNum++;
					sumlist.add(mlist);
				}
			}
		}
		
		// 섬의 각 지점에서 만들 수 있는 모든 에지 저장
		for (int i = 0; i < sumlist.size(); i++) {
			ArrayList<int[]> now = sumlist.get(i);
			
			for (int j = 0; j < now.size(); j++) {
				// 행 열 정보 꺼내기
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				// 현재 섬 몇 번 섬인지 확인
				int nowS = map[r][c];
				// 4 방향 탐색
				for (int d = 0; d < 4; d++) {
					int tempR = dr[d];
					int tempC = dc[d];
					int bridgeL = 0;
					
					while( r + tempR >= 0 && r + tempR < N && 
						   c + tempC >= 0 && c + tempC < M) {
						// 이동했더니 같은 섬 이내면 에지 만들지 불가능
						if (map[r + tempR][c + tempC] == nowS) break;
						// 다른 섬에 도달했다면
						else if (map[r + tempR][c + tempC] != 0) {
							if (bridgeL > 1)
								spTree.add(new Edge(nowS, map[r + tempR][c + tempC], bridgeL));
							break;
						} else
							bridgeL++;
						
						// 한 칸씩 더 옮겨가면서 확인
						if (tempR < 0) tempR--;
						else if (tempR > 0) tempR++;
						else if (tempC < 0) tempC--;
						else if (tempC > 0) tempC++;
					}
						
				}
			}
		}
		
		// parent 배열 섬 개수 이용해 초기화
		parent = new int[sumNum];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		// 최소 신장 트리 알고리즘 수행
		int edgeNum = 0;
		int result = 0;
		
		while (!spTree.isEmpty()) {
			Edge nowEdge = spTree.poll();
			int start = nowEdge.start;
			int end = nowEdge.end;
			int weight = nowEdge.weight;
			
			if (find(start) != find(end)) {
				union(start, end);
				edgeNum++;
				result += weight;
			}
		}
		
		// 초기에 섬 개수를 1로 설정하고 코드 진행했기 때문에 (섬 number를 1부터 시작하게 하기 위해)
		// 따라서 sumNum - 2 == edgeNum
		if (edgeNum == sumNum - 2)
			System.out.println(result);
		else 
			System.out.println(-1);
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
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		mlist = new ArrayList<>();
		// 시작 위치에서부터 BFS 수행
		int[] start = { i, j };
		
		queue.add(start);
		mlist.add(start);
		visited[i][j] = true;
		map[i][j] = sumNum;
		
		while(!queue.isEmpty()) {
			// 현재 위치
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for (int d = 0; d < 4; d++) {
				int tempR = dr[d];
				int tempC = dc[d];
				
				while (r + tempR >= 0 && r + tempR < N && 
					   c + tempC >= 0 && c + tempC < M) {
					// 현재 방문한 적이 없고 바다가 아니면 같은 섬으로 취급
					if (visited[r + tempR][c + tempC] == false && map[r + tempR][c + tempC] != 0) {
						addNode(r + tempR, c + tempC, queue);
					} else break;
					
					if (tempR < 0) tempR--;
					else if (tempR > 0) tempR++;
					else if (tempC < 0) tempC--;
					else if (tempC > 0) tempC++;
				}
			}
		}
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		map[i][j] = sumNum;
		visited[i][j] = true;
		int[] temp = { i, j };
		
		mlist.add(temp);
		queue.add(temp);
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
		// 오름차순 정렬
		return this.weight - e.weight;
	}
}
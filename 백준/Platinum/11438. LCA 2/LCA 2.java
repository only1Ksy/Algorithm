import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static ArrayList<Integer>[] tree;
    public static int[] depth;
    public static int kmax;
    public static int[][] parent;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        //StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        
        // 부모 노드 저장용 배열 
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
        	tree[i] = new ArrayList<Integer>();
        }
        
        // 인접 리스트로 트리 구현하기
        for (int i = 0; i < n - 1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	tree[a].add(b);
        	tree[b].add(a);
        }
        
        // 깊이 저장 배열 초기화하기
        depth = new int[n + 1];
        // BFS 용 방문 확인 배열 초기화하기
        visited = new boolean[n + 1];
        
        int temp = 1;
        kmax = 0;
        
        // 최대 깊이 구하기
        while (temp <= n) {
        	temp <<= 1; // 왼쪽으로 한 칸씩 미는 거니까 2의 제곱수로 증가 (깊이 구하기)
        	kmax++;
        }
        
        // BFS / DFS 로 노드 깊이 저장하기
        parent = new int[kmax + 1][n + 1];
        BFS(1);
        // 점화식으로 parent 배열 완성하기
        for (int k = 1; k <= kmax; k++) {
        	for (int N = 1; N <= n; N++) {
        		parent[k][N] = parent[k - 1][parent[k - 1][N]];
        	}
        }
        
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	int LCA = executeLCA(a, b);
        	
        	System.out.println(LCA);
        }
    }

    public static int executeLCA(int a, int b) {
    	// 무조건 더 높은 깊이를 b에 오도록 switch 하기
    	if (depth[a] > depth[b]) {
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	// depth를 맞추기
    	for (int k = kmax; k >= 0; k--) {
    		if (Math.pow(2, k) <= depth[b] - depth[a]) {
    			if (depth[a] <= depth[parent[k][b]]) {
    				b = parent[k][b];
    			}
    		}
    	}
    	
    	// 최소 공통 조상 찾기
    	for (int k = kmax; k >= 0; k--) {
    		if (parent[k][a] != parent[k][b]) {
    			a = parent[k][a];
    			b = parent[k][b];
    		}
    	}
    	
    	int LCA = a;
    	
    	if (a != b)
    		LCA = parent[0][LCA];
    	
    	return LCA;
    }
    
    public static void BFS(int root) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(root);
    	visited[root] = true;
    	
    	int lvl = 1;
    	int nowSize = 1;
    	int cnt = 0;
    	
    	while (!queue.isEmpty()) {
    		int nowNode = queue.poll();
    		
    		for (int next : tree[nowNode]) {
    			if (!visited[next]) {
    				visited[next] = true;
    				queue.add(next);
    				parent[0][next] = nowNode;
    				depth[next] = lvl;
    			}
    		}
    		// 모든 자식만큼 다 돌았으면 count 초기화 (lvl 구하기 용)
    		cnt++;
    		if (cnt == nowSize) {
    			cnt = 0;
    			nowSize = queue.size();
    			lvl++;
    		}
    	}
    }
}
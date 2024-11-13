import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int cnt = 0;
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static int depth[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];
        Arrays.fill(depth, -1);
        
        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	A[s].add(e);
        	A[e].add(s);
        }
        for (int i = 1; i < n+1; i++) {
            Collections.sort(A[i]);
        }
                
        DFS(r);

        for (int i = 1; i < n+1; i++) {
        	System.out.println(depth[i]);
        }
    }
    
    static void DFS(int v) {
    	
    	if (visited[v]) {
    		return;
    	}
    	depth[v] += 1;
    	
    	visited[v] = true; // 방문한 것으로 표시
    	for (int i : A[v]) { // 연결된 노드들에 대해
    		if (visited[i] == false) { // 아직 방문하지 않았다면
    			depth[i] = depth[v];
    			DFS(i); // 탐색 진행
    		}
    	}
    }
}

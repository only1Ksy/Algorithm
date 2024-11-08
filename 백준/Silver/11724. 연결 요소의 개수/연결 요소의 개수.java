import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        
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
        
        int cnt = 0;
        
        for (int i = 1; i < n+1; i++) {
        	if (!visited[i]) {
        		cnt++;
        		DFS(i);
        	}
        }

        System.out.println(cnt);
    }
    
    static void DFS(int v) {
    	if (visited[v]) {
    		return;
    	}
    	visited[v] = true; // 방문한 것으로 표시
    	for (int i : A[v]) { // 연결된 노드들에 대해
    		if (visited[i] == false) { // 아직 방문하지 않았다면
    			DFS(i); // 탐색 진행
    		}
    	}
    }
}

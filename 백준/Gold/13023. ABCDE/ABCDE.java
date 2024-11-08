import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static boolean arrive;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        arrive = false;
        
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	A[s].add(e);
        	A[e].add(s);
        }
        
        for (int i = 0; i < n; i++) {
        	DFS(i, 1);
        	
        	if (arrive) break;
        }
        
        if (arrive) System.out.println(1);
        else System.out.println(0);
    }
    
    static void DFS(int now, int depth) {
    	if (depth == 5 || arrive) { // 5 개 탐색되면 탐색 종료
    		arrive = true;
    		return;
    	}
    	
    	visited[now] = true;
    	for (int i : A[now]) {
    		if (!visited[i]) {
    			DFS(i, depth + 1);
    		}
    	}
    	
    	visited[now] = false; // 방문했던 지점 초기화해서 다음 main의 i 에서 돌 수 있도록
    }
}

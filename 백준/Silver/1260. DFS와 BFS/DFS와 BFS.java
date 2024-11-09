import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A;
	static ArrayList<Integer> aResult;
	static boolean visitedA[];
	static boolean visitedB[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visitedA = new boolean[n+1];
        visitedB = new boolean[n+1];

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
        	// ArrayList 오름차순 정렬
        }
        
        
        DFS(v);
        System.out.println();
        BFS(v);
    }
    
    static void DFS(int node) {
    	System.out.print(node + " ");
    	visitedA[node] = true;
    	for (int i : A[node]) {
    		if (!visitedA[i]) {
    			DFS(i);
    		}
    	}
    }
    
    static void BFS(int node) {
    	// 연결 리스트로 구현된 큐 선언
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(node);
    	
    	visitedB[node] = true;
    	
    	while (!queue.isEmpty()) {
    		// queue.poll <- 최상위 노드를 POP 하는 함수
    		int nowNode = queue.poll();
    		
    		System.out.print(nowNode + " ");
    		for (int i : A[nowNode]) {
    			if (!visitedB[i]) {
    				visitedB[i] = true;
    				queue.add(i);
    			}
    		}
    	}
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] arr;
	static int n;
	static int m;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String temp = st.nextToken();
        	
        	for (int j = 0; j < m; j++) {
        		arr[i][j] = Integer.parseInt(temp.substring(j, j+1));
        	}
        }   
        
        BFS(0, 0);
        System.out.println(arr[n-1][m-1]);
    }
    
    public static void BFS(int i, int j) {
    	Queue<int[]> queue = new LinkedList<>();
    	// 큐가 꽉 찼을 경우 false를 반환
    	queue.offer(new int[] {i, j});
    	visited[i][j] = true;
    	
    	while (!queue.isEmpty()) {
    		// queue에 들어있던 위치 pop
    		int now[] = queue.poll();
    		
    		for (int k = 0; k < 4; k++) {
    			int x = now[0] + dx[k];
    			int y = now[1] + dy[k];
    			// index 범위를 벗어나지 않고
    			if (x >= 0 && y >= 0 && x < n && y < m) {
    				// 방문하지 않았고, 0이 아닌 노드이면
    				if (arr[x][y] != 0 && !visited[x][y]) {
    					visited[x][y] = true;
    					// 깊이 누적값으로 update
    					arr[x][y] = arr[now[0]][now[1]] + 1;
    					queue.add(new int[] {x, y});
    				}
    			}
    		}
    	}
    }
}

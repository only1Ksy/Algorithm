import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static boolean visited[][];
	static int pixel[][];
	static int[] distance;
	static int n;
	static int m;
	
	static int[] dx = { -1,  0, 1, 0 };
	static int[] dy = {  0, -1, 0, 1 };
	
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        m = input.nextInt();
        int[][] r = new int[n][m];
        int[][] g = new int[n][m];
        int[][] b = new int[n][m];
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		r[i][j] = input.nextInt();
        		g[i][j] = input.nextInt();
        		b[i][j] = input.nextInt();
        	}
        }
        
        int t = input.nextInt();
        
        pixel = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		int avg = (r[i][j] + g[i][j] + b[i][j]) / 3;
        		if (avg >= t) {
        			pixel[i][j] = 255;
        		}
        	}
        }
        
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (pixel[i][j] == 255 && !visited[i][j]) {
        			DFS(i, j);
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);
    }
    
    public static void DFS(int x, int y) {
    	
    	visited[x][y] = true;
    	
    	for (int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
    		
    		if (pixel[nx][ny] == 255 && !visited[nx][ny]) {
    			DFS(nx, ny);
    		}
    	}
    }
}

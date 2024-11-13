import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static boolean visited[][];
	static char pixel[][];
	static int[] distance;
	static int n;
	
	static int[] dx = { -1,  0, 1, 0 };
	static int[] dy = {  0, -1, 0, 1 };
	
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        input.nextLine();
        pixel = new char[n][n];
        
        for (int i = 0; i < n; i++) {
        	String s = input.nextLine();
        	
        	for (int j = 0; j < n; j++) {
        		pixel[i][j] = s.charAt(j);
        	}
        }
               
        visited = new boolean[n][n];
        
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (!visited[i][j]) {
        			DFS_Normal(i, j);
        			cnt++;
        		}
        	}
        }
        
        visited = new boolean[n][n];
        
        int cnt1 = 0;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (!visited[i][j]) {
        			DFS_RedGreen(i, j);
        			cnt1++;
        		}
        	}
        }
        
        System.out.println(cnt + " " + cnt1);
    }
    
    public static void DFS_Normal(int x, int y) {
    	char color = pixel[x][y];
    	visited[x][y] = true;
    	
    	for (int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
    		
    		if (pixel[nx][ny] == color && !visited[nx][ny]) {
    			DFS_Normal(nx, ny);
    		}
    	}
    }
    
    public static void DFS_RedGreen(int x, int y) {
    	char color = pixel[x][y];
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            
            // 적록색약의 경우 'R'과 'G'를 같은 색상으로 처리합니다.
            if (color == 'B') {
                if (pixel[nx][ny] == 'B' && !visited[nx][ny]) {
                    DFS_RedGreen(nx, ny);
                }
            } else {  // color가 'R' 또는 'G'인 경우
                if ((pixel[nx][ny] == 'R' || pixel[nx][ny] == 'G') && !visited[nx][ny]) {
                    DFS_RedGreen(nx, ny);
                }
            }
        }
    }
}

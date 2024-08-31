import java.util.*;

class Position {
	int i; int j; int x; int y;
	public Position() {}	
	public Position(int i, int j, int x, int y) {
		this.i = i;
		this.j = j;
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		int [][] arr = new int[n][m];
		
		//배열 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
			input.nextLine();
		}
		
		int k = input.nextInt();
		input.nextLine();

		Position [] pp = new Position[k];
		
		for (int l = 0; l < k; l++) {
			int i = input.nextInt();
			int j = input.nextInt();
			int x = input.nextInt();
			int y = input.nextInt();
			
			pp[l] = new Position(i, j, x, y);
			input.nextLine();
		}
		
		for (int l = 0; l < k; l++) {
			int ans = 0;
			
			for (int r = pp[l].i; r <= pp[l].x; r++) {
				for (int t = pp[l].j; t <= pp[l].y; t++) {
					ans += arr[r-1][t-1];
				}
			}
			
			System.out.println(ans);
		}
	}
}
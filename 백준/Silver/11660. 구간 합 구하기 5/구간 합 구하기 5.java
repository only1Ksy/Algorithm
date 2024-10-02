import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        
        int[][] arr = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = input.nextInt();
                // 2차원 구간 합 계산
                sum[i][j] = arr[i][j] 
                          + sum[i-1][j]    // 위쪽 값 더하기
                          + sum[i][j-1]    // 왼쪽 값 더하기
                          - sum[i-1][j-1]; // 중복된 값 빼기
            }
        }
                
        for (int i = 0; i < m; i++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            
            // 구간 합 계산
            int result = sum[x2][y2]      // 값 더하기
                       - sum[x1-1][y2]    // 세로줄 빼기
                       - sum[x2][y1-1]    // 가로줄 빼기
                       + sum[x1-1][y1-1]; // 중복으로 빼진 값 더하기
            
            System.out.println(result);
        }
    }
}

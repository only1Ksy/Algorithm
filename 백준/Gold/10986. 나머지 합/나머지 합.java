import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        
        long[] arr = new long[n+1];
        // 각 구간 합의 나머지 저장
        long[] rem = new long[n+1];
        // 각 나머지의 개수를 저장
        long[] sum = new long[m];
        
        long cnt = 0;
        
        for (int i = 1; i < n+1; i++) {
        	arr[i] = input.nextInt();
        	// 각 구간합의 나머지를 배열에 저장
        	rem[i] = (arr[i] + rem[i-1])%m;
        	int r = (int) rem[i];
        	
        	if (r == 0) cnt++;
        	sum[r]++;
        }
        
        // 구간을 고르는 중첩 반복문
        for (int i = 0; i < m; i++) {
        	if (sum[i] > 1) { // sum[i] C 2 -> C[i]부터 두 개 * / 2!
        		cnt = cnt + (sum[i] * (sum[i] - 1) / 2);
        	}
        }
        
        System.out.println(cnt);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        long[] num = new long[n];
        
        // 입력 받기
        for (int k = 0; k < n; k++) {
            num[k] = input.nextInt();
        }
        
        // 정렬
        Arrays.sort(num);
        int cnt = 0;

        // 각 숫자를 기준으로 나머지 두 숫자의 합이 되는지 확인
        for (int index = 0; index < n; index++) {
            int i = 0;
            int j = n - 1;
            
            while (i < j) {
                // 자기 자신은 사용하지 않도록 처리
                if (i == index) {
                    i++;
                    continue;
                }
                if (j == index) {
                    j--;
                    continue;
                }
                
                // 두 수의 합이 num[index]와 같다면
                if (num[i] + num[j] == num[index]) {
                    cnt++;
                    break;  // 하나라도 찾으면 바로 종료
                }
                // 두 수의 합이 더 크다면 j 감소
                else if (num[i] + num[j] > num[index]) {
                    j--;
                }
                // 두 수의 합이 더 작다면 i 증가
                else {
                    i++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}

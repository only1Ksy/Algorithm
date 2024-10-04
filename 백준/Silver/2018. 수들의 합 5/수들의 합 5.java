import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int stIndex = 1;
        int endIndex = 1;
        int cnt = 1; // n 그 자체를 사용하는 경우
        int sum = 1; // 1은 이미 더해진 상태로 출발 (end, start 인덱스 모두 1부터 시작)
                
        while (endIndex != n) {
        	if (sum == n) {
        		cnt++; 
        		endIndex++;
        		sum += endIndex;
        	}
        	else if (sum < n) {
        		endIndex++; // 끝 인덱스 오른쪽으로 한 칸 이동해 뒷 숫자 더해주기
        		sum += endIndex;
        	}
        	else {
        		sum -= stIndex;
        		stIndex++; // 시작 인덱스 오른쪽으로 한 칸 이동해 앞 숫자 빼주기
        	}
        }
        
        System.out.println(cnt);
    }
}
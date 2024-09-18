import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			int n = input.nextInt();
			int k = input.nextInt();
			
			int cnt = n;
			
			while (n >= k) {
				cnt += n/k;
				//몫만큼 더 시켰으므로 쿠폰 개수++, 나머지 더해주기
				n = n/k + n%k;
			}
			
			System.out.println(cnt);
		}

	}

}


import java.util.*;

public class Main {
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static final int INT_MIN = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		int v = input.nextInt();
				
		// 마지막 날 빼고 나머지에 대한 계산 (일수)
		int cnt = (v-b)/(a-b);
		// 아직 갈 거리가 남은 경우
		if ((v-b)%(a-b) != 0) cnt++;
		
		System.out.println(cnt);
		
	}

}

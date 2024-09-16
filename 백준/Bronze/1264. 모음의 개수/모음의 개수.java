import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			String s = input.nextLine().toLowerCase();
			int cnt = 0;
			
			if (s.equals("#")) break;
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
						|| s.charAt(i) == 'o' || s.charAt(i) == 'u') {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}

	}

}

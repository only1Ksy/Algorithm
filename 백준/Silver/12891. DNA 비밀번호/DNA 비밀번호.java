import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int cnt = 0;
        
        int s = input.nextInt();
        int p = input.nextInt();
        
        String st = input.next();
        // a, c, g, t의 개수를 셀 배열
        int[] num = new int[4];
        
        for (int i = 0; i < p; i++) {
        	if (st.charAt(i) == 'A') num[0]++;
    		else if (st.charAt(i) == 'C') num[1]++;
    		else if (st.charAt(i) == 'G') num[2]++;
    		else if (st.charAt(i) == 'T') num[3]++;
        }
        
        int a = input.nextInt();
        int c = input.nextInt();
        int g = input.nextInt();
        int t = input.nextInt();
        
        if (num[0] >= a && num[1] >= c && num[2] >= g && num[3] >= t) cnt++;
        
        for (int i = 0; i < s-p; i++) {
        	if (st.charAt(i) == 'A') num[0]--;
    		else if (st.charAt(i) == 'C') num[1]--;
    		else if (st.charAt(i) == 'G') num[2]--;
    		else if (st.charAt(i) == 'T') num[3]--;
        	
        	if (st.charAt(i+p) == 'A') num[0]++;
    		else if (st.charAt(i+p) == 'C') num[1]++;
    		else if (st.charAt(i+p) == 'G') num[2]++;
    		else if (st.charAt(i+p) == 'T') num[3]++;
        	
            if (num[0] >= a && num[1] >= c && num[2] >= g && num[3] >= t) cnt++;
        }
       
        
        System.out.println(cnt);
    }
}
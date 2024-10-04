import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int[] num = new int[n];
        int m = input.nextInt();
        
        int i = 0;
        int j = n-1;
        
        int cnt = 0;
                
        for (int k = 0; k < n; k++) {
        	num[k] = input.nextInt();
        }
        
        Arrays.sort(num);
        
        while (i < j) {
        	if (num[i] + num[j] > m) {
        		j--;
        	}
        	else if (num[i] + num[j] < m) {
        		i++;
        	}
        	else {
        		i++; j--;
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
}
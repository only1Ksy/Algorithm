import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int cnt = 0;
	static int[] A;
	static int[] B;
	static boolean visited[];
	static int depth[];
	
    public static void main(String[] args) throws IOException {
    	Scanner input = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = input.nextInt();
        int k = input.nextInt();
        
        long start = 1, end = k;
        long ans = 0;
        
        while (start <= end) {
        	long middle = (start + end) / 2;
        	long cnt = 0;
        	
        	for (int i = 1; i <= n; i++) {
        		cnt += Math.min(middle/i, n);
        	}
        	if (cnt < k) {
        		start = middle + 1;
        	} else {
        		ans = middle;
        		end = middle - 1;
        	}
        }
        
        System.out.println(ans);
    }

}

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
        int m = input.nextInt();
        
        A = new int[n];
        
        int start = 0, end = 0;
        
        for (int i = 0; i < n; i++) {
            A[i] = input.nextInt();
            
            if (start < A[i]) start = A[i];
            end = end + A[i];
        }
        
        while (start <= end) {
        	int middle = (start + end) / 2;
        	int sum = 0;
        	int cnt = 0;
        	
        	for (int i = 0; i < n; i++) {
        		if (sum + A[i] > middle) {
        			cnt++;
            		sum = 0;
        		}
            	sum += A[i];
        	}
        	if (sum != 0) cnt++;
        	if (cnt > m) start = middle + 1;
        	else end = middle - 1;
        }
        
        System.out.println(start);
        
    }

}

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
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = input.nextInt();
        
        A = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = input.nextInt();
        }
        
        Arrays.sort(A);
        
        int m = input.nextInt();
        
        for (int i = 0; i < m; i++) {
        	boolean find = false;
        	
        	int target = input.nextInt();
        	
        	int start = 0;
        	int end = n - 1;
        	
        	while (start <= end) {
        		int midi = (start + end) / 2;
        		int midValue = A[midi];
        		
        		if (midValue > target) {
        			end = midi -1;
        		} else if (midValue < target) {
        			start = midi + 1;
        		} else {
        			find = true;
        			break;
        		}
        	}
        	
        	if (find) System.out.println(1);
        	else System.out.println(0);
        }
        
    }

}

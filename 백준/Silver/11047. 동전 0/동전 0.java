import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static boolean visited[][];
	static char pixel[][];
	static int[] distance;
	static int[] A;
	static int n;
	
	static int[] dx = { -1,  0, 1, 0 };
	static int[] dy = {  0, -1, 0, 1 };
	
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int k = input.nextInt();
        
        A = new int[n];
        
        for (int i = 0; i < n; i++) {
        	A[i] = input.nextInt();
        }
        
        int value = k;
        int index = n-1;
        int cnt = 0;
        
        while (true) {
        	if (value - A[index] >= 0) {
        		value -= A[index];
        		cnt++;
        	} else {
        		index--;
        	}
        	
        	if (value == 0) break;
        }
        
        System.out.println(cnt);
    }
}
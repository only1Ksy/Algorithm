import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int n;
	
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    
    static void DFS(int num, int jari) {
    	if (jari == n) { // n자릿수에 도달하면 종료
    		if (isPrime(num)) {
    			System.out.println(num);
    		}
    	}
    	
    	for (int i = 1; i < 10; i++) {
    		if (i % 2 == 0) {
    			continue; // 짝수 건너뛰기
    		}
    		if (isPrime(num * 10 + i)) {
    			DFS(num * 10 + i, jari + 1);
    		}
    	}
    }
    
    static boolean isPrime(int num) {
    	for (int i = 2; i <= num / 2; i++) {
    		if (num % i == 0) // 하나로라도 나누어지면 false
    			return false;
    	}
    	return true;
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        
        int[] num = new int[n + 1];  
        int[] sum = new int[n + 1]; 

        for (int i = 1; i <= n; i++) {
            num[i] = input.nextInt();
            sum[i] = sum[i - 1] + num[i]; 
        }
        
        for (int i = 0; i < m; i++) {
            int I = input.nextInt();
            int J = input.nextInt();
            System.out.println(sum[J] - sum[I - 1]); 
        }
    }
}
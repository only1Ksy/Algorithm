import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        int N, X;
        double max = 0;
        double mid = 0;
        double sum = 0;
        
        N = input.nextInt();
        String temp = input.nextLine();
        
        double [] A = new double[N];
        double [] B = new double[N];        
        
        for (int i = 0; i < N; i++) {
        	A[i] = input.nextDouble();
        }
        
        for (int i = 0; i < N; i++) {
        	if (A[i] > max)
        		max = A[i];
        	else
        		continue;
        }
        
        for (int i = 0; i < N; i++) {
        	B[i] = (A[i]/max)*100;
        	sum += B[i];
        }
        
        System.out.println(sum/N);
    }
}
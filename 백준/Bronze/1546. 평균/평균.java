import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		input.nextLine();
		
		double [] arr1 = new double[n];
		double [] arr2 = new double[n];
		double max = 0;
		
		for (int i = 0; i < n; i++) {
			arr1[i] = input.nextDouble();
			max = Math.max(max, arr1[i]);
		}
		
		double sum = 0;
		
		for (int i = 0; i < n; i++) {
			arr2[i] = arr1[i]/max * 100;
			sum += arr2[i];
		}
		
		double ave = sum / n;
		
		System.out.println(ave);
	}
}

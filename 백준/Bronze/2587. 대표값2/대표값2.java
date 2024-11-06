import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {
	public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Scanner input = new Scanner(System.in);
        
        int[] arr = new int[5];
        int sum = 0;
        int median = 0;
        
        for (int i = 0; i < 5; i++) {
        	arr[i] = input.nextInt();
        	sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
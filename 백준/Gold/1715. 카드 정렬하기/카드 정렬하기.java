import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		PriorityQueue <Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int data = input.nextInt();
			pq.add(data);
		}
		
		int data1 = 0; int data2 = 0;
		int sum = 0;
		
		while(pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			
			sum += data1 + data2;
			
			pq.add(data1 + data2);
		}
		
		System.out.println(sum);
	}
}
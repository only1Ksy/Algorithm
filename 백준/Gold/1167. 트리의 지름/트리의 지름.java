import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
        	A[i] = new ArrayList<Edge>();
        }
        
        for (int i = 0; i < n; i++) {
        	int s = input.nextInt();
        	while (true) {
        		int e = input.nextInt();
        		if (e == -1) break;
        		
        		int v = input.nextInt();
        		A[s].add(new Edge(e, v));
        	}
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        
        BFS(1);
        int Max = 1;
        
        for (int i = 2; i <= n; i++) {
        	if (distance[Max] < distance[i])
        		Max = i;
        }
        
        distance = new int[n+1];
        visited = new boolean[n+1];
       
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }
    
    public static void BFS(int index) {
    	Queue<Integer> queue = new LinkedList<>();

    	queue.add(index);
    	visited[index] = true;
    	
    	while (!queue.isEmpty()) {
    		int nowNode = queue.poll();
    		
    		for (Edge i : A[nowNode]) {
    			int e = i.e;
    			int v = i.val;
    			if (!visited[e]) {
    				visited[e] = true;
    				queue.add(e);
    				distance[e] = distance[nowNode] + v;
    			}
    		}
    	}
    }
}

class Edge{
	int e;
	int val;
	public Edge(int e, int val) {
		this.e = e;
		this.val = val;
	}
}

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> d = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 덱이 비어 있지 않고, 마지막 값이 방금 입력받은 것보다 크면 제거
            while (!d.isEmpty() && d.getLast().value > num) {
                d.removeLast();
            }

            d.addLast(new Node(num, i));

            // 덱의 첫 번째 값이 윈도우 범위를 벗어나면 제거
            if (d.getFirst().index <= i - l) {
                d.removeFirst();
            }

            // 현재 윈도우의 최솟값 출력
            bw.write(d.getFirst().value + " ");
        }
        
        bw.flush();  // 출력 버퍼 비우기
    }
}
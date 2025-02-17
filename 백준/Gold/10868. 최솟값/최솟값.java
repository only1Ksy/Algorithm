import java.io.*;
import java.util.*;

public class Main {
    public static long[] tree;
    public static int n, m;
    public static int leftLeafNodeIdx, treeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int treeHeight = (int) Math.ceil(Math.log(n) / Math.log(2));
        treeSize = (int) Math.pow(2, treeHeight + 1);
        leftLeafNodeIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        for (int i = leftLeafNodeIdx + 1; i <= leftLeafNodeIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        buildTree();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(minValue(leftLeafNodeIdx + a, leftLeafNodeIdx + b));
        }
    }

    // tree Build 부터 최솟값으로
    public static void buildTree() {
        for (int i = treeSize / 2 - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public static long minValue(int start, int end) {
        long minVal = Long.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) minVal = Math.min(minVal, tree[start++]);
            if (end % 2 == 0) minVal = Math.min(minVal, tree[end--]);
            start /= 2;
            end /= 2;
        }

        return minVal;
    }
}

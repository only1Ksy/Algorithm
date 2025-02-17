import java.io.*;
import java.util.*;

public class Main {
    public static long[] tree;
    public static int n, m, k;
    public static int leftLeafNodeIdx, treeSize;
    public static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int treeHeight = (int) Math.ceil(Math.log(n) / Math.log(2));
        treeSize = (int) Math.pow(2, treeHeight + 1);
        leftLeafNodeIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        for (int i = leftLeafNodeIdx + 1; i <= leftLeafNodeIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        buildTree();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(b, c);
            } else if (a == 2) {
                System.out.println(partMult(leftLeafNodeIdx + b, (int) (leftLeafNodeIdx + c)));
            }
        }
    }

    public static void buildTree() {
        for (int i = treeSize / 2 - 1; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
        }
    }

    public static void update(int idx, long value) {
        int pos = treeSize / 2 + idx - 1;
        tree[pos] = value % MOD;

        while (pos > 1) {
            pos /= 2;
            tree[pos] = (tree[pos * 2] * tree[pos * 2 + 1]) % MOD;
        }
    }

    public static long partMult(int start, int end) {
        long partMult = 1;

        while (start <= end) {
            if (start % 2 == 1) partMult = (partMult * tree[start++]) % MOD;
            if (end % 2 == 0) partMult = (partMult * tree[end--]) % MOD;
            start /= 2;
            end /= 2;
        }

        return partMult;
    }
}

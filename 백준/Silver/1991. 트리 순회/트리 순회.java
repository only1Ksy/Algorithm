import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Node[] tree;

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new Node[26];  // A ~ Z

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[data - 'A'] == null) {
                tree[data - 'A'] = new Node(data);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[data - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[data - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);  // 전위 순회
        System.out.println();
        inorder(tree[0]);   // 중위 순회
        System.out.println();
        postorder(tree[0]); // 후위 순회
        System.out.println();
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}

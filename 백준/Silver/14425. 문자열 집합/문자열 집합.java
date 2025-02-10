import java.util.*;
import java.io.*;

public class Main {
	// 문자열 개수 N(집합 S에 포함된 문자열), M(검사해야 하는 문자열)
	public static int N, M;
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = input.nextInt();
		M = input.nextInt();
		
		tNode root = new tNode();

		for (int i = 0; i < N; i++) {
			String text = input.next();
			// 문자열 입력받고 정보 저장
			tNode now = root;
			
			for (int j = 0; j < text.length(); j++){
				char c = text.charAt(j);
				// 현재 노드에 연결된 알파벳 c 자리 배열이 공석이라면
				if (now.next[c - 'a'] == null) {
					// 새로운 노드를 추가하여 해당 노드에 연결
					now.next[c - 'a'] = new tNode();
				}
				
				now = now.next[c - 'a'];
				
				// 문자열의 끝을 표시
				if (j == text.length() - 1) {
					now.isEnd = true;
				}
			}
		}

		int result = 0;
		
		
		for (int i = 0; i < M; i++) {
			String text = input.next();
			// 루트 노드부터 시작
			tNode now = root;
			
			for (int j = 0; j < text.length(); j++){
				char c = text.charAt(j);
				// 현재 노드에 연결된 알파벳 c 자리 배열이 공석이라면
				if (now.next[c - 'a'] == null) {
					// 포함되지 않는 문자열
					break;
				}
				
				now = now.next[c - 'a'];
				
				// 문자열의 끝을 표시
				if (j == text.length() - 1 && now.isEnd) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

class tNode {
	tNode[] next = new tNode[26];
	boolean isEnd;
}
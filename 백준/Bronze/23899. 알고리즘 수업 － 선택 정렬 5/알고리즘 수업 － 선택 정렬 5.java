import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(selectionSort(arr, arr2, n));
    }
    
    public static int selectionSort(int[] arr, int[] arr2, int n) {
        // 초기 상태 비교
        if (Arrays.equals(arr, arr2)) return 1;

        for (int i = n - 1; i >= 1; i--) {
            int maxIdx = 0;
            
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            
            // maxIdx 위치와 i 위치가 다르면 교환
            if (i != maxIdx) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
            
            // 교환 후 상태 비교
            if (Arrays.equals(arr, arr2)) return 1;
        }
        return 0;
    }
}

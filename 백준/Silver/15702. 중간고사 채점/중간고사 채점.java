import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Student implements Comparable<Student> {
    String number;
    int[] result;
    
    public Student(String number, int n) {
        this.number = number;
        result = new int[n];
    }
    
    public int getScore() {
        int sum = 0;
        for (int score : result) {
            sum += score;
        }
        return sum;
    }

    @Override
    public int compareTo(Student student) {
        int thisScore = this.getScore();
        int otherScore = student.getScore();

        if (thisScore != otherScore) {
            return otherScore - thisScore;  // 높은 점수가 우선
        }
        return Integer.parseInt(this.number) - Integer.parseInt(student.number);  // 수험 번호가 작은 것이 우선
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄: 문제 수 N, 응시자 수 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 둘째 줄: 문제별 배점 입력
        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // M명의 학생 정보를 입력받음
        Student[] students = new Student[m];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String number = st.nextToken();  // 수험 번호
            students[i] = new Student(number, n);

            // 각 문제의 채점 결과
            for (int j = 0; j < n; j++) {
                char result = st.nextToken().charAt(0);
                students[i].result[j] = (result == 'O') ? scores[j] : 0;
            }
        }

        // 학생들을 점수와 수험 번호에 따라 정렬
        Arrays.sort(students);

        // 최고 점수를 얻은 학생의 정보 출력
        System.out.println(students[0].number + " " + students[0].getScore());
    }
}

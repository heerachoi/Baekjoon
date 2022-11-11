// 문제
// N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.

// 출력
// 첫째 줄에 경우의 수를 출력한다.

// 예제 입력 1 
// 4 2
// 1 1 1 1
// 예제 출력 1 
// 3
// 예제 입력 2 
// 10 5
// 1 2 3 4 2 5 3 1 1 2
// 예제 출력 2 
// 3

//알고리즘: 투 포인터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class addnums2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt (st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int intervalSum = 0;
        int count = 0;
        int end = 0;

        for (int start=0; start<n; start++) {
            while (intervalSum < m && end < n) {
                intervalSum += arr[end++];
            }
            if (intervalSum == m) {
                count++;
            }
            intervalSum -= arr[start];
        }
        System.out.println(count);
    }
}

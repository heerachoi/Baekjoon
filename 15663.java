// 문제해설
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-15663-N%EA%B3%BC-M-9-JAVA%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int past = -1;
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (visit[i] || past == now) { // 중복 O
                continue;
            } else {
                //중복 X
                past = now;
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}

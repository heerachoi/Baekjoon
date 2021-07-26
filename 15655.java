// 문제링크: https://www.acmicpc.net/problem/15655
// 문제설명: https://coder-design.tistory.com/entry/Baekjoon-%EB%AC%B8%EC%A0%9CJava%EB%B0%B1%EC%A4%80-15654-N%EA%B3%BC-M-6-JAVA%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9

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
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i < arr.length; i++) { //i에 at을 설정해 줌으로써 7 1이 아닌 7 8이 시작되게 한다.
            if (!visit[i]) { // 있으면 같은 숫자가 안나오게 한다
                visit[i] = true;
                result[depth] = arr[i];
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}


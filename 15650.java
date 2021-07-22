//링크: https://www.acmicpc.net/problem/15650
// 문제
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.
// 입력
// 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

// 출력
// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

// 예제 입력 1 
// 3 1
// 예제 출력 1 
// 1
// 2
// 3
// 예제 입력 2 
// 4 2
// 예제 출력 2 
// 1 2
// 1 3
// 1 4
// 2 3
// 2 4
// 3 4

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) { //at - 현재 위치, 즉 어디서부터 시작하는지를 의미한느 변수이다
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[depth] = i; //현재 깊이의 위치에 i 값을 담는다
            dfs(i + 1, depth + 1); //재귀호출: 현재 i 값보다 다음 재귀에서 더 커야하므로 i + 1 의 값을 넘겨준다
        }
    }
}


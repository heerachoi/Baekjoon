// 링크: https://www.acmicpc.net/problem/15649
// 알고리즘: 백트레킹, dfs

// 문제
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
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
// 2 1
// 2 3
// 2 4
// 3 1
// 3 2
// 3 4
// 4 1
// 4 2
// 4 3

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int arr[];
    public static boolean visit[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [M];
        visit = new boolean[N]; //숫자의 방문여부를 체크한다
        dfs(0); //dfs, 초기 0부터 시작한다
        System.out.println(sb); //최종 답을 뽑아낸다

    }
    public static void dfs(int depth) {
        if (depth == M) { //깊이가 M과 같을때
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(' '); //sb에 저장한다
            }
            sb.append('\n');
            return; //밑에 dfs()다음으로 넘어가 방문했던 곳을 false로 set 해준다
        }
        for (int i = 0; i < N; i++) {
            if(!visit[i]) { //배열에 방문을 하지 않았다면
                visit[i] = true; //방문 처리를 한다
                arr[depth] = i+1; //arr에 값을 추가해준다
                dfs(depth+1); //깊이를 늘려분다
                visit[i] = false; //return 되었을때 배열 방문여부를 false로 set 해준다
            }
        }

    }
}

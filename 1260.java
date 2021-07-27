// 문제 설명 링크
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-1260-DFS%EC%99%80-BFS-JAVADFSBFS

import java.util.*;
import java.io.*;

public class Main {
    // 함수에 사용할 변수들
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int k; // 시작 정점
    static ArrayList<Integer> arr[];
    static boolean[] isVisit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1]; // 좌표를 그대로 받아들이기 위해 +1 사용
        isVisit = new boolean[N + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) { // 간선 열결 상태 저장
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        dfs(k);
        isVisit = new boolean[N + 1];
        sb.append("\n");
        bfs(k);
        System.out.println(sb);
    }

    public static void dfs(int index) {
        isVisit[index] = true;
        sb.append(index + " ");
         for(int i : arr[index]) {
            if (!isVisit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int index) {
        isVisit[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()) {
            int a = q.poll();
            sb.append(a + " ");
            for (int i: arr[a]) {
                if(!isVisit[i]) {
                    q.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}

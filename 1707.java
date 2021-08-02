import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static ArrayList<Integer>[] al;
    static int visit[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 테스트 케이스의 개수

        for(int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken()); // 정점의 개수
            e = Integer.parseInt(st.nextToken()); // 간선의 개수
            visit = new int[v+1]; // 방문 여부 확인
            al = new ArrayList[v+1];

            for(int i = 0; i <= v; i++)
                al[i] = new ArrayList<Integer>();

            for(int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                al[p1].add(p2);
                al[p2].add(p1);
            }
            bfs();
        }
        System.out.print(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i <= v; i++) {
            if(visit[i] == 0) {
                q.add(i);
                visit[i] = 1; // 방문 처리
           }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int j = 0; j < al[now].size(); j++) {
                    if(visit[al[now].get(j)] == 0) {
                        q.add(al[now].get(j));
                    }
                    if(visit[al[now].get(j)] == visit[now]) {
                        sb.append("NO").append("\n");
                        return;
                    }

                    if(visit[now] == 1 && visit[al[now].get(j)] == 0) {
                        visit[al[now].get(j)] = 2;
                    }
                    else if(visit[now] == 2 && visit[al[now].get(j)] == 0) {
                        visit[al[now].get(j)] = 1;
                    }
                }
            }
        }
        sb.append("YES").append("\n");
    }

}

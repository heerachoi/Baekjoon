//문제 설명
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-1987-%EC%95%8C%ED%8C%8C%EB%B2%B3-JAVADFS

import java.io.*;
import java.util.*;
 
public class Main {
 
 
    static ArrayList<String> arr = new ArrayList<>(); // 이동 개수 저장
    static int map[][];
    static boolean isVisit[] = new boolean [26];
    static int ans = 0 ;
    static int R,C;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
 
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0 ,0);
        System.out.println(ans);
    }
    static void dfs(int x, int y, int count) {
        if (isVisit[map[x][y]]) {
            ans = Math.max(ans, count);
            return;
        } else {
            isVisit[map[x][y]] = true; // 방문 처리르 해준다
            for (int i = 0; i < 4; i ++) {
                int cx = x + dx[i]; // 앞으로 이동할 인덱스 변경
                int cy = y + dy[i];
                if (cx >= 0 && cy >= 0 && cx < R && cy < C) { // 맵의 범위를 넘지 않을때
                    dfs(cx, cy, count + 1);
                }
            }
            isVisit[map[x][y]] = false;
        }
    }
}

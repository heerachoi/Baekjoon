// 문제 
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-10026-%EC%A0%81%EB%A1%9D%EC%83%89%EC%95%BD-JAVADFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visited;
    static StringBuffer sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine()); // 사이즈
        map = new char[N][N];
        sb = new StringBuffer();

        for (int i = 0; i < N; i++) { // 입력 값 기록
            map[i] = br.readLine().toCharArray();
        }

        //1. 적록색약 아닌 사람
        visited = new boolean[N][N];
        // process 에서 dfs를 한다
        sb.append(process()).append(" "); //구역의 수

        //2. 적록색약인 사람
        visited = new boolean[N][N]; // 방문체크 초기화
        for (int i = 0; i < N; i++) {// 초록색을 빨간색으로 교체

            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
        sb.append(process());
        System.out.println(sb.toString());
    }

    private static int process() {

        int cnt = 0; //구역의 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                ++cnt;
                visited[0][0] = true;
                dfs(i,j);
            }
        }
        return cnt;
    }

    private static void dfs(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc]) continue;
            if(map[nr][nc] != map[r][c]) continue; // 새로 이동할 곳의 값이 지금 값과 다를때 다음걸로 넘어간다. 다르기 때문에 깊이 갈 필요가 없다.

            visited[nr][nc]=true; //앞으로 갈 곳을 방문처리 해준다.
            dfs(nr,nc);
        }
    }
}

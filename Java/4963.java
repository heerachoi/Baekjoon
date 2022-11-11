// 문제 설명
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-4963-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-JAVADFS

import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    // 왼쪽대각선위부터, 시계반대방향으로 왼쪽, 왼쪽 대각선 밑, 아래, 오른쪽 대각선 밑, 오른쪽, 오른쪽 대각선 위, 위 까지 총 8가지
    static int[] d_col = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] d_row = {-1, 0, 1, 1, 1, 0, -1, -1};
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 넓이
            h = Integer.parseInt(st.nextToken()); // 높이
            map = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0; // 섬 개수

            if (w == 0 && h == 0) { // while loop이 끝난다
                break;
            }
            for (int i = 0; i < h; i++) { // 땅과 바다 값을 저장한다
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) { // 방문하지 않았고 땅이면
                        dfs(i, j);
                        cnt++; // 섬의 개수
                    }
                }
            }
            arr.add(cnt); // 섬의 개수를 arr에 기록한다
        }
        for (int i = 0 ; i < arr.size(); i++) { // 섬의 개수를 뽑아낸다
            System.out.println(arr.get(i));
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;
        // 8 -> 8가지의 길
        for (int i = 0; i < 8; i++) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];
            // 앞으로 나아갈 길이 범위를 벗어나는지 확인한다
            if (next_row < 0 || next_row >= h || next_col < 0 || next_col >= w) {
                continue;
            }
            // 만약 앞으로 나아갈 길이 땅이고 방문하지 않았다면
            if (map[next_row][next_col] == 1 && !visited[next_row][next_col]) {
                dfs(next_row, next_col);
            }
        }
    }
}

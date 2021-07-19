// 문제
// ‘쩰리’는 점프하는 것을 좋아하는 젤리다. 단순히 점프하는 것에 지루함을 느낀 ‘쩰리’는 새로운 점프 게임을 해보고 싶어 한다. 새로운 점프 게임의 조건은 다음과 같다.

// ‘쩰리’는 가로와 세로의 칸 수가 같은 정사각형의 구역 내부에서만 움직일 수 있다. ‘쩰리’가 정사각형 구역의 외부로 나가는 경우엔 바닥으로 떨어져 즉시 게임에서 패배하게 된다.
// ‘쩰리’의 출발점은 항상 정사각형의 가장 왼쪽, 가장 위의 칸이다. 다른 출발점에서는 출발하지 않는다.
// ‘쩰리’가 이동 가능한 방향은 오른쪽과 아래 뿐이다. 위쪽과 왼쪽으로는 이동할 수 없다.
// ‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리로 게임은 종료된다.
// ‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼이다. 칸에 쓰여 있는 수 초과나 그 미만으로 이동할 수 없다.
// 새로운 게임이 맘에 든 ‘쩰리’는, 계속 게임을 진행해 마침내 최종 단계에 도달했다. 하지만, 게임을 진행하는 구역이 너무 넓어져버린 나머지, 이 게임에서 이길 수 있는지 없는지 가늠할 수 없어졌다. ‘쩰리’는 유능한 프로그래머인 당신에게 주어진 구역에서 승리할 수 있는 지 알아봐 달라고 부탁했다. ‘쩰리’를 도와 주어진 게임 구역에서 끝 점(오른쪽 맨 아래 칸)까지 도달할 수 있는지를 알아보자!

// 입력
// 입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다.

// 입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.

// 게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.

// 출력
// ‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력합니다.

// 예제 입력 1 
// 3
// 1 1 10
// 1 5 1
// 2 2 -1

// 예제 출력 1 
// HaruHaru
// 쩰리는 맨 왼쪽 위의 칸에서 출발해 (행, 열)로 나타낸 좌표계로,  (1, 1) -> (2, 1) -> (3, 1) -> (3, 3)으로 이동해 게임에서 승리할 수 있다.

// 예제 입력 2 
// 3
// 2 2 1
// 2 2 2
// 1 2 -1
// 예제 출력 2 
// Hing

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair { // class를 생성해줌으로써 하나의 객체 안에 행과 열의 좌표, 즉 해당 숫자의 위치를 저장할 수 있기 때문에 매우 편리하다.
    int x;
    int y;
    int jump;

    public Pair(int x, int y, int jump) {
        this.x = x;
        this.y = y;
        this.jump = jump;
    }
}
public class jumpkingjellySmall {
    static int N, answer;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pair> q = new LinkedList<Pair>(); // < > 안에 Generic으로 Integer가 아닌 다른 객체 class가 와도 된다. Ex. Pair.
    // Pair class를 사용하면 queue에 x좌표, y좌표를 함께 저장할 수 있다는 장점이있다. 그러면 push와 pop을 두 번씩 해주지 않아도 된다는 장점이 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int row = 0; row < N; row++) {
            String[] input = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(input[col]);
                System.out.println("map[row][col] = " + map[row][col]);
            }
        }
        visit[0][0] = true;
        q.add(new Pair(0,0,map[0][0]));
        bfs();
    }
    private static void bfs() {
        while(!q.isEmpty()) {
            Pair pair = q.poll(); // 첫번째 값을 반환하고 제거
            int x = pair.x;
            int y = pair.y;
            int jump = pair.jump;
            System.out.println("In BFS = x=" + x + " y = " + y + " jump = " + jump);
            //아래로 갈 경우 범위 및 방문 여부 체크
            if (x + jump < N && !visit[x+jump][y]) {
                System.out.println("아래로 visit [" + x+jump+ "][" + y + "]  = " + visit[x+jump][y]);
                //맨 오르쪽 래로 갈수 있을 경우 리턴
                if(map[x +jump][y] == -1) {
                    System.out.println("HaruHaru");
                    return;
                }
                // 아닐 경우 아래로 이동할 인스턴스 정보 큐에 저장
                visit[x+ jump][y] = true;
                q.add(new Pair(x+jump, y, map[x+jump][y]));
                System.out.println("큐에 저장 아래로= x=" + x+jump + " y =" + y + " map[x+jump][y] =" + map[x+jump][y]);
            }

            // 오른쪽으로 갈 경우 범위 및 방문 여부 체크
            if (y + jump < N && !visit[x][y+jump]) {
                System.out.println("오른쪽으로 visit [" + x + "][" + y+jump + "]  = " + visit[x][y+jump]);
                //맨 오른쪽 아래로 갈수 있을 경우 리턴
                if (map[x][y+jump] == -1) {
                    System.out.println("HaruHaru");
                    return;
                }
                // 아닐 경우 오른쪽으로 이동할 인스턴스 정보 큐에 저장
                visit[x][y+jump] = true;
                q.add(new Pair(x,y+jump, map[x][y+jump]));
                System.out.println("큐에 저장 오른쪽으로= x=" + x + " y = " + y+jump + " map[" + x + "][" + y+jump + "] = " + map[x][y+jump]);

            }
        }
        System.out.println("Hing");
    }
}

// 문제
// 형택이는 건축가이다. 지금 막 형택이는 형택이의 남자 친구 기훈이의 집을 막 완성시켰다. 형택이는 기훈이 방의 바닥 장식을 디자인했고, 이제 몇 개의 나무 판자가 필요한지 궁금해졌다. 나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다. 기훈이 방은 직사각형 모양이고, 방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다.

// 이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.

// 기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. N과 M의 제한은 100이다.

// 출력
// 첫째 줄에 문제의 정답을 출력한다.

// 예제 입력 1 
// 4 4
// ----
// ----
// ----
// ----
// 예제 출력 1 
// 4

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //System.out.print("");과 동일하게 사용가능한 함수이다.
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()); //need to add IOException

        int MAX_COLS = Integer.parseInt(st.nextToken()); //세로크기
        int MAX_ROWS = Integer.parseInt(st.nextToken()); //가로크
        char graph[][] = new char[MAX_COLS][MAX_ROWS]; //문자담을 배열 초기
        int ansCount = 0;
        for (int i = 0; i < MAX_COLS; i++) {
            graph[i] = br.readLine().toCharArray(); //String을 char배열로 바꿔준다.
            for (int j = 0; j < MAX_ROWS; j++) {
                if (graph[i][j] == '-') {
                    ansCount++;
                    while (j < MAX_ROWS && graph[i][j] == '-') {
                        j++;
                    }
                }
            }
        }
        // 연이은 | 찾기
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j=0; j <MAX_COLS; j++) {
                if (graph[j][i] == '|') {
                    ansCount++;
                    while(j < MAX_COLS && graph[j][i] == '|'){
                        j++;
                    }
                }
            }
        }
        sb.append(ansCount);
        sb.append("\n");
        bw.write(sb.toString()); //출력
        bw.flush(); //남아 있는 데이터를 두 출력 //답 출력
        br.close();
        bw.close(); //스트림
    }
}

import java.io.*;
import java.util.*;
 
public class Main {
    static int row,col;
    static char ad[][];
    static boolean visit[][];
    static int cntO = 0;
    static int cntV = 0;
    static int total_cntO = 0;
    static int total_cntV = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
 
        ad = new char[row][col];
        visit = new boolean[row][col];
 
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < col; j++){
                ad[i][j] = str.charAt(j);
            }
        }
 
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(ad[i][j] != '#' && !visit[i][j]) {
                    cntO = 0;
                    cntV = 0;
                    bfs(i, j);
                }
            }
        }
 
        System.out.print(total_cntO + " " + total_cntV);
    }
 
    static void bfs(int start, int end){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        q.offer(end);
        visit[start][end] = true;
        while(!q.isEmpty()){
            start = q.poll();
            end = q.poll();
            if(ad[start][end] == 'o')
                cntO++;
            else if(ad[start][end] == 'v')
                cntV++;
            for(int i = 0; i < 4; i++){
                int X = start + dx[i];
                int Y = end + dy[i];
                if(isRangeTrue(X,Y) && ad[X][Y] != '#' && !visit[X][Y]){
                    q.offer(X);
                    q.offer(Y);
                    visit[X][Y] = true;
                }
            }
        }
        if(cntV >= cntO)
            total_cntV += cntV;
        else
            total_cntO += cntO;
    }
 
    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y <col;
    }
}

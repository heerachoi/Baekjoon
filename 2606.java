// 문제 설명
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-2606-%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4-JAVABFS
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> arr[];
    static int check[];
    static int cnt=0;
    static ArrayList<Integer> result =new ArrayList<>();
    static StringTokenizer st;
    static int map[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        map = new int[N+1];
        ArrayList<Integer> arr[] = new ArrayList[N+1];
        for(int i = 1 ; i < N+1 ; i++) { // 열결 상태 저장
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < T ; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
            arr[to].add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        map[1] = 1;
        int cnt =0 ;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < arr[now].size() ; i++) {
                int next = arr[now].get(i);
                if(map[next] != 1) { // 방문하지 않았다
                    map[next] = 1;
                    q.add(next);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

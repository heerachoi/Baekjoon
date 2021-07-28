// 문제설명
// https://coder-design.tistory.com/entry/%EB%B0%B1%EC%A4%80-2667-%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%EB%B6%99%EC%9D%B4%EA%B8%B0-JAVADFS
import java.io.*;
import java.util.*;

public class Main {
    static int node[][];
    static int check[][];
    static int cnt =1;
    static ArrayList<Integer> array = new ArrayList<>();

    static void dfs(int x,int y) {
        check[x][y] =1;

        if( y<node.length-1 && node[x][y+1]==1 && check[x][y+1]==0) {
            cnt++;
            dfs(x,y+1);
        }

        if(x<node.length-1 && node[x+1][y]==1&& check[x+1][y]==0) {
            cnt++;
            dfs(x+1,y);
        }

        if(y>0 &&  node[x][y-1]==1&& check[x][y-1]==0) {
            cnt++;
            dfs(x,y-1);

        }

        if(x>0 &&  node[x-1][y]==1&& check[x-1][y]==0) {
            cnt++;
            dfs(x-1,y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        node = new int[n][n];
        check = new int[n][n];
        for(int i=0;i<node.length;i++) {
            String row = br.readLine();
            for(int j=0;j<node[i].length;j++) {
                node[i][j] = row.charAt(j)-'0';
            }
        }
        for(int i=0;i<node.length;i++) {
            for(int j=0;j<node[i].length;j++) {
                if(node[i][j] == 1 && check[i][j]==0) {
                    cnt =1;
                    dfs(i,j);
                    array.add(cnt);
                }
            }
        }
        System.out.println(array.size());
        Collections.sort(array);
        for(int i=0;i<array.size();i++) {
            System.out.println(array.get(i));
        }
    }
}

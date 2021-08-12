import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] candidates;
    public static int[] numArray;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        candidates = new int[N];
        numArray = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int index = 0; index<N; index++){
            candidates[index] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(candidates);

        pickNums(0, 0, bw);
        bw.flush();

        br.close();
        bw.close();
    }

    public static void pickNums(int index ,int startIndex, BufferedWriter bw) throws Exception{
        if(index>=M){
            for(int num : numArray){
                bw.write(String.valueOf(num)+" ");
            }
            bw.write("\n");
        }
        else{
            int beforeNum = -1;
            for(int i = startIndex ; i<N ; i++){
                if(beforeNum!= candidates[i]){
                    numArray[index] = candidates[i];
                    beforeNum = candidates[i];

                    pickNums(index+1, i+1, bw);
                }
            }
        }
    }
}

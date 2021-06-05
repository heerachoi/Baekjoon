import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sbb = new StringBuilder();
    
    static void solve() throws IOException {
        //System.setIn(new FileInputStream("c:/Dev/git/algo/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = null;
        //stt = new StringTokenizer(br.readLine(), "-");
        
        int ans = 0;
        String[] in1 = br.readLine().split("-");
        for(int i = 0; i < in1.length; i++) {
            int sum = sum(in1[i]);
            if(i != 0) sum *= -1;
            ans += sum;
        }
        
        print(ans);
        
        br.close();
        bw.close();
    }
    
    static int sum(String S) {
        String[] in2 = S.split("\\+");
        int sum = 0;
        for(int i = 0; i < in2.length; i++) {
            sum += stoi(in2[i]);
        }
//        print(sum);
        return sum;       
    }
    
    public static void main(String[] args) throws Exception {
        solve();
    }
    
    static int stoi(String s) { return Integer.parseInt(s); }
    static long stol(String s) { return Long.parseLong(s); }
    static void print(String s) { System.out.println(s); }
    static void print(int opih) { System.out.println(opih); }
    static void print(long opih) { System.out.println(opih); }    
    static void print(char opih) { System.out.println(opih); }    
    static void print(StringBuilder sbb) { System.out.println(sbb.toString()); }
    static void print() { System.out.println(); }
}

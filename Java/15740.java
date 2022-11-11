// 문제
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 A와 B (-1010000 ≤ A, B ≤ 1010000)가 주어진다.

// 출력
// 첫째 줄에 A+B를 출력한다.

// 예제 입력 1 
// 1 2
// 예제 출력 1 
// 3
// 예제 입력 2 
// -60 40
// 예제 출력 2 
// -20
// 예제 입력 3 
// -999999999 1000000000

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger b1 = new BigInteger(st.nextToken());
        BigInteger b2 = new BigInteger(st.nextToken());
        System.out.println(b1.add(b2));

    }
}

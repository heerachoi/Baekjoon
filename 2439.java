// 문제
// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

// 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

// 입력
// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

// 출력
// 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

// 예제 입력 1 
// 5
// 예제 출력 1 
//     *
//    **
//   ***
//  ****
// *****


import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int current = 1;

        for (int i = 1; i <= input; i++) {
            while(current <= i) {
                System.out.print("*");
                current++;
            }
            System.out.println("");
            current= 1;
        }
    }
}


// StringBuilder 사용하면 runtime이 훨씬 빠르다.

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class Main {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
// 		br.close();
// 		StringBuilder str1 = new StringBuilder();
// 		for(int i = n; i > 0; i--) {
// 			for(int j = 1; j <= n; j++) {
// 				if(j >= i) {
// 					str1.append("*");
// 				} else {
// 					str1.append(" ");
// 				}
// 			}
// 			str1.append("\n");
// 		}
// 		System.out.println(str1);
// 	}
// }

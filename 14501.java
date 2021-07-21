//링크: https://www.acmicpc.net/problem/14501
// 문제
// 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.

// 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.

// 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.

// 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

// N = 7인 경우에 다음과 같은 상담 일정표를 보자.

//  	1일	2일	3일	4일	5일	6일	7일
// Ti	3	  5	   1	  1	  2	   4	 2
// Pi	10	20	 10	 20	  15	40	200
// 1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.

// 상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.

// 또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.

// 퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.

// 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.

// 둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)

// 출력
// 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.

// 예제 입력 1 
// 7
// 3 10
// 5 20
// 1 10
// 1 20
// 2 15
// 4 40
// 2 200
// 예제 출력 1 
// 45

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] T = new int[N+10]; // work day
        int [] P = new int[N+10]; // pay amount
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1]; // N일에 얻을 수 있는 최대 수익
        //점화식
        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장한다. 이후, 중복될 때 최대값을 넣는다.
        for (int i=0; i<N; i++) {
            System.out.println("i = " + i);
            if (i + T[i] <= N) { //날짜가 범위를 넘어가지 않을 때
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어준다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println("");
        }
        System.out.println(dp[N]);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int e=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		for(int n=1, i=1, j=1, k=1;;n++,i++,j++,k++) {
			i=i%15==0?15:i%15;
			j=j%28==0?28:j%28;
			k=k%19==0?19:k%19;
			if(e==i && s==j && m==k) {
				System.out.println(n);
				break;
			}
		}
	}
}

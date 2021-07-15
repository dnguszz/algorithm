import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19939 {
	static int n, k;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(k*(k+1)/2 >n) {
			System.out.println(-1);
			System.exit(0);
		}
		n -= k*(k+1)/2;
		if(n%k==0) {
			System.out.println(k-1);
		}
		else {
			System.out.println(k);
		}
	}
}

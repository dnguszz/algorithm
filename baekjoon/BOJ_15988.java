import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988 {
	static long dp[];
	public static void main(String[] args) throws IOException{
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 dp = new long[1000001];
		 dp[1]=1;
		 dp[2]=2;
		 dp[3]=4;
		 for (int i = 4; i < 1000001; i++) {
			dp[i]=(dp[i-3]+dp[i-2]+dp[i-1])%1000000009;
		}
		 int test = Integer.parseInt(bf.readLine());
		 for (int tc = 0; tc < test; tc++) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(dp[n]);
		}
	}
}

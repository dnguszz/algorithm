import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9625 {
	static int n;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		dp = new int[46][2];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		if(n<3) {
			System.out.println(dp[n][0]+" "+dp[n][1]);
			System.exit(0);
		}
		for (int i = 3; i <= n; ++i) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		System.out.println(dp[n][0]+" "+dp[n][1]);
	}
}	

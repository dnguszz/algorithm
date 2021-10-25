import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		dp = new int[n + 1];
		dp[1] = 0;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); 
		}
		System.out.println(dp[n]);
	}
}

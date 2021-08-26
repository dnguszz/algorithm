import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	static int n;
	static int[] card, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		card = new int[n + 1];
		dp = new int[n + 1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
			}
		}

		System.out.println(dp[n]);
	}
}

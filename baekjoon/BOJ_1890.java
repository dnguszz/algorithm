import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1890 {
	static int n;
	static int[][] map;
	static long[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		dp = new long[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) continue;
				int val = map[i][j];
				if(i+val<n) dp[i+val][j]+=dp[i][j];
				if(j+val<n) dp[i][j+val]+=dp[i][j];
			}
		}
		System.out.println(dp[n-1][n-1]);
	}
}

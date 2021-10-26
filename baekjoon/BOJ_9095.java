package algostudy_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			n = Integer.parseInt(bf.readLine());
			dp = new int[n+1];
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			for (int i = 4; i < n+1; i++) {
				dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}

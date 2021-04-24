package algo0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1328 {
	static int n, l, r;
	static long[][][] dp = new long[101][101][101]; // n, l, r
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		//100개에서 100개뽑는 순열 = 100! 안댐
		//
		dp[1][1][1]=1;
		//dp[3]부터
		//개수 1 증가할때마다 1층씩 올라갔다치고 가장 작은빌딩(1)을 맨 왼쪽, 오른쪽, 가운데에 배치함
		//왼쪽에 배치하면 = l 1 증가
		//오른쪽 = r 1 증가
		//나머지는 l이랑 r 증가 없음
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= l; j++) {
				for (int k = 1; k <= r; k++) {
					dp[i][j][k]=(dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k] * (i-2))%1000000007;
				}
			}
		}
		System.out.println(dp[n][l][r]);
		
	}
}

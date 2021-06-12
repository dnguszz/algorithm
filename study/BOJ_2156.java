package daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
	static int n;
	static int[] ans;
	static int[] wine;
	/*
	 * dp
	 * 3개연속으로 못고르니까
	 * n개와인(0~n-1) 주어졌으면
	 * 0개까지의 최대값, 1개까지의 최대, 2개까지의 최대... 이렇게 구해보는걸로
	 * 하나도안마심, 1개마심, 2개마심으로 나뉠수있으니까 점화식에서 이 값들의 최대로 넣어보면
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		wine = new int[n+1];
		ans = new int[n+1];
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(bf.readLine());
		}
		ans[1]=wine[1];
		if(n==1) {
			System.out.println(ans[1]);
			System.exit(0);
		}
		ans[2]=wine[1]+wine[2];
		if(n==2) {
			System.out.println(ans[2]);
			System.exit(0);
		}
		for (int i = 3; i <= n; i++) {
			ans[i]=Math.max(ans[i-2]+wine[i],ans[i-3]+wine[i-1]+wine[i]);
			ans[i]=Math.max(ans[i], ans[i-1]);
		}
		System.out.println(ans[ans.length-1]);
	}
}

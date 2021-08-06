import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052 {
	static int n, k, ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int cnt=n;
		ans=0;
		while(true) {
			String temp = Integer.toBinaryString(cnt);
			if(findB(temp)<=k) {
				System.out.println(ans);
				System.exit(0);
			}
			cnt++;
			ans++;
		}
	}
	
	public static int findB(String s) {
		int res=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='1') {
				res++;
			}
		}
		return res;
	}
}

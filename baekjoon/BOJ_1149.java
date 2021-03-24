package algo0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int n;
	static int[][] map;
	static int[][] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][3];
		ans = new int[n][3];
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			map[i][0]=Integer.parseInt(st.nextToken());
			map[i][1]=Integer.parseInt(st.nextToken());
			map[i][2]=Integer.parseInt(st.nextToken());
		}
		ans[0][0]=map[0][0];
		ans[0][1]=map[0][1];
		ans[0][2]=map[0][2];
		for(int i=1 ; i<n ; i++) {
			ans[i][0]=Math.min(ans[i-1][1], ans[i-1][2])+map[i][0];
			ans[i][1]=Math.min(ans[i-1][0], ans[i-1][2])+map[i][1];
			ans[i][2]=Math.min(ans[i-1][0], ans[i-1][1])+map[i][2];
		}
		Arrays.sort(ans[n-1]);
		System.out.println(ans[n-1][0]);
		
	}
}

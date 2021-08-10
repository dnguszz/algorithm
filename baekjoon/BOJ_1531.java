package algostudy_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1531 {
	static int n ,m;
	static int[][] map;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[101][101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			make(a,b,c,d);
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]>m) ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static void make(int a, int b, int c, int d) {
		for (int i = a; i <= c; i++) {
			for (int j = b; j <= d; j++) {
				map[i][j]++;
			}
		}
	}
}

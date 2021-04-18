package algo0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249 {
	static int n;
	static int[][] map;
	static int[][] dis;
	static boolean[][] vis;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int MAX = 99999999;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= test; tc++) {
			n = Integer.parseInt(bf.readLine());
			map = new int[n][n];
			dis = new int[n][n];
			vis = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String st = bf.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j]=(int) st.charAt(j)-'0';
				}
				Arrays.fill(dis[i], MAX);
			}
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {0,0});
			vis[0][0]=true;
			dis[0][0]=0;
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				for (int i = 0; i < 4; i++) {
					if(temp[0]+dx[i]>=0 && temp[0]+dx[i]<n && 
							temp[1]+dy[i]>=0 && temp[1]+dy[i]<n) {
							if(map[temp[0]+dx[i]][temp[1]+dy[i]]+
									dis[temp[0]][temp[1]] < dis[temp[0]+dx[i]][temp[1]+dy[i]]) {
								dis[temp[0]+dx[i]][temp[1]+dy[i]] = map[temp[0]+dx[i]][temp[1]+dy[i]]+
										dis[temp[0]][temp[1]];
								q.offer(new int[] {temp[0]+dx[i], temp[1]+dy[i]});
								vis[temp[0]+dx[i]][temp[1]+dy[i]] = true;
							}
					}
				}
			}
			System.out.println("#"+tc+" "+dis[n-1][n-1]);
		}
	}

}

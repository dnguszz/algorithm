package algo0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static int n, a1, a2;
	static char map[][];
	static boolean vis[][];
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static char val;
	static int area, area2;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		area=0;
		area2=0;
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String st = bf.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j]=st.charAt(j);
			}
		}
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!vis[i][j]) {
					val = map[i][j];
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					vis[i][j]=true;
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int a = temp[0];
						int b = temp[1];
						for (int k = 0; k < 4; k++) {
							if(a+dx[k]>=0 && a+dx[k]<n && b+dy[k]>=0 && b+dy[k]<n) {
								if(!vis[a+dx[k]][b+dy[k]] && map[a+dx[k]][b+dy[k]]==val) {
									q.offer(new int[] {a+dx[k], b+dy[k]});
									vis[a+dx[k]][b+dy[k]]=true;
								}
							}
						}
					}
					area++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]=='G') map[i][j]='R';
			}
		}
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!vis[i][j]) {
					val = map[i][j];
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					vis[i][j]=true;
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int a = temp[0];
						int b = temp[1];
						for (int k = 0; k < 4; k++) {
							if(a+dx[k]>=0 && a+dx[k]<n && b+dy[k]>=0 && b+dy[k]<n) {
								if(!vis[a+dx[k]][b+dy[k]] && map[a+dx[k]][b+dy[k]]==val) {
									q.offer(new int[] {a+dx[k], b+dy[k]});
									vis[a+dx[k]][b+dy[k]]=true;
								}
							}
						}
					}
					area2++;
				}
			}
		}
		System.out.println(area);
		System.out.println(area2);
	}
}

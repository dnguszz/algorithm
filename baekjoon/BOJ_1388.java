import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1388 {
	static int n, m;
	static boolean[][] vis;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		vis = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]=temp.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!vis[i][j]) {
					ans++;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int x = temp[0];
						int y = temp[1];
						if(map[x][y]=='-') {
							for (int k = 2; k < 4; k++) {
								if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<m) {
									if(!vis[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]]=='-') {
										q.offer(new int[] {x+dx[k], y+dy[k]});
										vis[x+dx[k]][y+dy[k]]=true;
									}
								}
							}
						}
						else { //|
							for (int k = 0; k < 2; k++) {
								if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<m) {
									if(!vis[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]]=='|') {
										q.offer(new int[] {x+dx[k], y+dy[k]});
										vis[x+dx[k]][y+dy[k]]=true;
									}
								}
							}
						}
					}
				}
				
			}
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int n, m, k, ans;
	static int[][] map;
	static boolean[][] vis;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int test = 0; test < tc; test++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			vis = new boolean[n][m];
			ans=0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]==1) {
						ans++;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] {i,j});
						vis[i][j]=true;
						while(!q.isEmpty()) {
							int[] temp =q.poll();
							int x = temp[0];
							int y = temp[1];
							for (int k = 0; k < 4; k++) {
								if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<m) {
									if(!vis[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]]==1) {
										q.offer(new int[] {x+dx[k], y+dy[k]});
										map[x+dx[k]][y+dy[k]]=0;
										vis[x+dx[k]][y+dy[k]]=true;
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
}

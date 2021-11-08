import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int n, m, k;
	static boolean[][] vis;
	static int cnt;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static ArrayList<Integer> list;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());//5
		n = Integer.parseInt(st.nextToken());//7
		k = Integer.parseInt(st.nextToken());
		vis = new boolean[n][m];
		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			for (int j = ax; j <bx; j++) {
				for (int u = ay; u < by; u++) {
					vis[j][u]=true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!vis[i][j]) {
					ans++;
					cnt=1;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					vis[i][j]=true;
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int x = temp[0];
						int y = temp[1];
						for (int k = 0; k < 4; k++) {
							if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<m && !vis[x+dx[k]][y+dy[k]]) {
								q.offer(new int[] {x+dx[k], y+dy[k]});
								vis[x+dx[k]][y+dy[k]]=true;
								cnt++;
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		System.out.println(ans);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}

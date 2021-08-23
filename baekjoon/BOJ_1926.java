import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int n, m;
	static int map[][];
	static boolean vis[][];
	static Queue<int[]> q;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static int volume=0;
	static int max=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		vis = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cnt=0;
				if(!vis[i][j] && map[i][j]==1) {
					cnt++;
					volume++;
					q = new LinkedList<>();
					q.offer(new int[] {i,j});
					vis[i][j]=true;
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int x = temp[0];
						int y = temp[1];
						for (int k = 0; k < 4; k++) {
							if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<m) {
								if(!vis[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]]==1) {
									q.offer(new int[] {x+dx[k], y+dy[k]});
									vis[x+dx[k]][y+dy[k]]=true;
									cnt++;
								}
							}
						}
					}
					
				}
				if(cnt!=0 && cnt>max) max=cnt;
			}
		}
		if(volume==0) {
			System.out.println(0);
			System.out.println(0);
		}
		else {
			System.out.println(volume);
			System.out.println(max);
		}
	}
}

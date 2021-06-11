import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
	static int n;
	static int[][] map;
	static boolean[][] vis;
	static int[] start, end;
	static int ans;
	static int[] dx = {-1,-2,-2,-1, 1,2,2,1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			n = Integer.parseInt(bf.readLine());
			map = new int[n][n];
			vis = new boolean[n][n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			start = new int[2];
			end = new int[2];
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {start[0], start[1], 0});
			vis[start[0]][start[1]]=true;
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				int count=temp[2];
				if(x==end[0] && y==end[1]) {
					ans = count;
					break;
				}
				for (int i = 0; i < 8; i++) {
					if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {
						if(!vis[x+dx[i]][y+dy[i]]) {
							q.offer(new int[] {x+dx[i], y+dy[i], count+1});
							vis[x+dx[i]][y+dy[i]]=true;
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}

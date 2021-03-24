package algo0324;

import java.io.*;
import java.util.*;

public class BOJ_2636 {
	static int n, m;
	static int[][] map;
	static int ans;
	static int count=0;
	static boolean[][] vis;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		boolean flag=false;
		while(!flag) {
			vis = new boolean[n][m];
			list = new ArrayList<>();
			vis[0][0]=true;
			ans=findCh();
			BFS(0,0);
			for(int i=0 ; i<list.size() ; i++) {
				int x = list.get(i)[0];
				int y = list.get(i)[1];
				for(int j=0 ; j<4 ; j++) {
					if(x+dx[j]>=0 && x+dx[j]<n && y+dy[j]>=0 && y+dy[j]<m) {
						map[x+dx[j]][y+dy[j]]=0;
					}
				}
			}
			count++;
			flag=isend();
		}
		System.out.println(count);
		System.out.println(ans);
	}
	public static void BFS(int x, int y) {
		list.add(new int[] {x,y});
		for(int i=0 ; i<4 ; i++) {
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m) {
				if(!vis[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]==0) {
					vis[x+dx[i]][y+dy[i]]=true;
					BFS(x+dx[i], y+dy[i]);
				}
			}
		}
	}
	public static boolean isend() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}
	public static int findCh() {
		int ans=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==1) ans++;
			}
		}
		return ans;
	}
}

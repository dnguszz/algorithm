package algo0324;

import java.io.*;
import java.util.*;

public class BOJ_16236 {
	static int n;
	static int[][] map;
	static boolean[][] vis;
	static int x, y;
	static int size, feed, ans, fish;;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<int[]> list = new ArrayList<>();
	static ArrayList<Integer> list2;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		feed=0;
		ans=0;
		fish=0;
		size=2;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					x=i;
					y=j;
					map[i][j]=-9;
				}
				else if(map[i][j]!=0) {
					fish++;
				}
			}			
		}		
		while(fish!=0) {
			list.clear();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]<size && map[i][j]!=0 && map[i][j]!=-9) {
						//xy부터 ij까지의 최단거리
						vis = new boolean[n][n];
						int temp=dist(x,y,i,j,0);
						list.add(new int[] {i, j, temp}); //거리를 직선거리가 아닌 최단경로로
					}
				}				
			}
			if(list.size()==0) {
				break;
			}
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {					
					return o1[2]-o2[2];
				}				
			});
			if(list.get(0)[2]!=Integer.MAX_VALUE-100) {
				map[x][y]=0;
				x=list.get(0)[0];
				y=list.get(0)[1];
				map[x][y]=-9;
				feed++;
				if(feed==size) {
					size++;
					feed=0;
				}
				ans+=list.get(0)[2];
				fish--;
			}
			else break;
		}
		System.out.println(ans);		
	}
	
	public static int dist(int a, int b, int i, int j, int cnt) {
		vis[a][b]=true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a,b,cnt});
		int ans=Integer.MAX_VALUE-100;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp[0]==i && temp[1]==j) {
				ans=temp[2];
				break;
			}
			for (int l = 0; l < 4; l++) {
				if(temp[0]+dx[l]<n && temp[0]+dx[l]>=0 && temp[1]+dy[l]<n && temp[1]+dy[l]>=0 && map[temp[0]+dx[l]][temp[1]+dy[l]]<=size) {
					if(!vis[temp[0]+dx[l]][temp[1]+dy[l]]) {
						vis[temp[0]+dx[l]][temp[1]+dy[l]]=true;
						q.offer(new int[] {temp[0]+dx[l], temp[1]+dy[l], temp[2]+1});
					}
				}
			}
		}
		return ans;
	}
}
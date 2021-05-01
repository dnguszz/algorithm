package algo0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609 {
	static int ans=0;
	static int n, m;
	static int map[][];
	static boolean[][] vis;
	static ArrayList<ArrayList<int[]>> list;
	static int[] dx= {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		
		while(true) {
			ArrayList<int[]> templist = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]==0) templist.add(new int[] {i,j});
				}
			}
			vis = new boolean[n][n];
			list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!vis[i][j] && map[i][j]>0) {
						list.add(BFS(i,j));
					}
					for (int j2 = 0; j2 < templist.size(); j2++) { //무지개블록 비망문처리
						vis[templist.get(j2)[0]][templist.get(j2)[1]]=false;
					}
				}
			}//블록찾은다음
			int size=-999;
			int index=0;
			for (int i = 0; i < list.size(); i++) {
				int temp = list.get(i).size();
				if(temp>size) {
					size=temp;
					index=i;
				}
				else if(temp==size) {
					int a = findrainbow(list.get(index));
					int b = findrainbow(list.get(i));
					if(a<=b) index=i;
				}
			}//가장큰블록구함
			if(size<=1) break; //더이상 2 이상의 블록이 없을때
			
			ans+=Math.pow(list.get(index).size(),2);
			
			for (int i = 0; i < list.get(index).size(); i++) {
				map[list.get(index).get(i)[0]][list.get(index).get(i)[1]]=-2; //빈칸을 -2로
			}
			
			grav();
			rot();
			grav();
			
		
		}
		System.out.println(ans);
		
	}
	
	public static ArrayList<int[]> BFS(int x, int y) {
		int val = map[x][y];
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> lis = new ArrayList<>();
		q.offer(new int[] {x,y});
		lis.add(new int[] {x,y});
		vis[x][y]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0 ; i<4 ; i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!vis[nx][ny]) {
						if(map[nx][ny]==val || map[nx][ny]==0) {
							q.offer(new int[] {nx, ny});
							lis.add(new int[] {nx, ny});
							vis[nx][ny]=true;
						}
					}
				}
			}
		}
		return lis;
	}
	public static int findrainbow(ArrayList<int[]> list) {
		int ans=0;
		for (int i = 0; i < list.size(); i++) {
			if(map[list.get(i)[0]][list.get(i)[1]]==0) ans++;
		}
		return ans;
	}
	
	public static void grav() {
		for (int i = 0; i < n; i++) {
			int[] arr = new int[n];
			for (int j = n-1; j >= 0; j--) {
				arr[n-1-j]=map[j][i];
			}
			for (int j = 0; j < n; j++) {
				if(arr[j]>-1) {
					int temp=arr[j];
					int index=j;
					while(true) {
						if(index-1>=0 && arr[index-1]==-2) {
							index--;
						}
						else break;
					}
					arr[j]=-2;
					arr[index]=temp;
				}
			}
			for (int j = n-1; j >= 0; j--) {
				map[j][i]=arr[n-1-j];
			}
		}
	}
	
	public static void rot() {
		int[][] tempmap = new int[n][n];
		for (int i = 0; i < tempmap.length; i++) {
			tempmap[i]=map[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j]=tempmap[j][n-1-i];
			}
		}
    }

}

package algo0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18428 {
	static int n;
	static String[][] map;
	static String[][] mapC;
	static int[] arr;
	static boolean[] vis;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static ArrayList<int[]> list;
	static int flag2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new String[n][n];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st  = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=st.nextToken();
				if(map[i][j].equals("T")) {
					list.add(new int[] {i,j});
				}
			}
		}
		arr = new int[3];
		vis = new boolean[n*n];
		C(0,0);
		System.out.println("NO");
	}
	
	private static void C(int start,int cnt) {
		if(cnt==3) {
			mapC = new String[n][n];
			for (int j = 0; j < n; j++) {
				mapC[j]=map[j].clone();
			}
			for (int i = 0; i < 3; i++) {
				int a = arr[i]/n;
				int b = arr[i]%n;
				if(mapC[a][b].equals("T") || mapC[a][b].equals("S")) {
					return;
				}
				mapC[a][b]="O";
			}
			boolean flag=true;
			
			boolean flag3 = true;
			for (int j = 0; j < list.size(); j++) {
				flag = true;
				flag2=1;
				for (int j2 = 0; j2 < 4; j2++) {
					search(list.get(j)[0], list.get(j)[1], j2);
					if(flag2==0) { //학생부딪힘
						flag3=false;
					}
				}
			}
			if(flag3) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < n*n; i++) {
			 arr[cnt]=i;
			 C(i+1, cnt+1);
		}
	}
	
	public static void search(int x, int y, int dir) {
		if(x+dx[dir]>=0 && x+dx[dir]<n && y+dy[dir]>=0 && y+dy[dir]<n) {
			if(mapC[x+dx[dir]][y+dy[dir]].equals("S")) {
				flag2=0;
				return;
			}
			else if(mapC[x+dx[dir]][y+dy[dir]].equals("O")) { //장애물
				flag2=1;
				return;
			}
			else if(mapC[x+dx[dir]][y+dy[dir]].equals("X")) { //빈공간
				search(x+dx[dir], y+dy[dir], dir);
			}
		}
		return;
	}
}

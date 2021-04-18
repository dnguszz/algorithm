package algo0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_5656 {
	static int n, w, h;
	static int[][] map;
	static int[][] mapC;
	static int[] arr;
	static boolean vis[];
	static ArrayList<int[]> list;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int ans;
	static int MIN;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= test; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			MIN = 9999999;
			mapC = new int[h][w];
			arr = new int[n];
			vis = new boolean[w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			P(0);
			System.out.println("#"+tc+" "+MIN);
		}
	}
	
	public static void P(int cnt) {
		if(cnt==n) {
			ans=0;
			int temp=0;
			for (int i = 0; i < h; i++) {
				mapC[i]=map[i].clone();
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < h; j++) {
					if(mapC[j][arr[i]]!=0) {
						list = new ArrayList<>();
						pop(j, arr[i]);
						down();
						break;
					}
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(mapC[i][j] == 0) {
						temp++;
					}
				}
			}
			ans=h*w-temp;
			if(ans < MIN) {
				MIN=ans;
			}
			return;
		}
		for (int i = 0; i < w; i++) {
			arr[cnt]=i;
			P(cnt+1);
		}
	}
	
	public static void pop(int a, int b) {
		int size = mapC[a][b]-1;
		if(size<=0) {
			mapC[a][b]=0;
			ans++;
			return;
		}
		mapC[a][b]=0;
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < 4; j++) {
				if(a+(i*dx[j])>=0 && a+(i*dx[j])<h && b+(i*dy[j])>=0 && b+(i*dy[j])<w) {
					if(mapC[a+(i*dx[j])][b+(i*dy[j])]>1) {
						pop(a+(i*dx[j]), b+(i*dy[j]));
					}
					mapC[a+(i*dx[j])][b+(i*dy[j])]=0;
				}
			}
		}
	}
	
	public static void down() {
		for (int i = 0; i < w; i++) {
			ArrayList<Integer> lis = new ArrayList<>();
			for (int j = h-1; j >= 0; j--) {
				if(mapC[j][i]!=0) {
					lis.add(mapC[j][i]);
				}
				mapC[j][i]=0;
			}
			lis.remove((Integer) 0);
			for (int j = 0 ; j<lis.size() ; j++) {
				mapC[h-1-j][i]=lis.get(j);
			}
		}
	}
}

package algo0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	static int k, w, h;
	static int[][] map;
	static boolean[][][] vis;
	static Queue<int[]> q;
	static int[] hdx = { -2, -1,  1,  2,-2,-1, 1, 2};
	static int[] hdy = { -2, -2, -2, -1, 1, 2, 2, 1};
	static int[] mdx = { 0, -1, 0, 1 };
	static int[] mdy = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		vis = new boolean[k + 1][h][w];
		q = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS();
	}

	public static void BFS() {
		q.add(new int[] { 0, 0, 0, 0 });
		vis[0][0][0]=true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[0] == h - 1 && temp[1] == w - 1) {
				System.out.println(temp[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int a = temp[0] + mdx[i];
				int b = temp[1] + mdy[i];
				if (a >= 0 && a < h && b >= 0 && b < w) {
					if (!vis[temp[3]][a][b] && map[a][b] != 1) {
						vis[temp[3]][a][b] = true;
						q.offer(new int[] { a, b, temp[2] + 1, temp[3] });
					}
				}
			}
			if (temp[3] + 1 <= k) {
				for (int i = 0; i < 8; i++) {
					int a = temp[0] + hdx[i];
					int b = temp[1] + hdy[i];
					if (a >= 0 && a < h && b >= 0 && b < w) {
						if (!vis[temp[3] + 1][a][b] && map[a][b] != 1) {
							vis[temp[3] + 1][a][b] = true;
							q.offer(new int[] { a, b, temp[2] + 1, temp[3] + 1 });
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
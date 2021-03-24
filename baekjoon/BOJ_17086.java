package algo0324;

import java.io.*;
import java.util.*;

public class BOJ_17086 {
	static int n, m;
	static int map[][];
	static boolean vis[][];
	static ArrayList<shark> list;
	static ArrayList<Integer> ans;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static class shark {
		int x;
		int y;
		int dist;

		shark(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		vis = new boolean[n][m];
		list = new ArrayList<>();
		ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					ans.add(find(i, j));
				}
			}
		}
		System.out.println(Collections.max(ans));
	}

	public static int find(int a, int b) {
		vis = new boolean[n][m];
		vis[a][b] = true;
		Queue<shark> q = new LinkedList<>();
		q.offer(new shark(a, b, 0));
		while (!q.isEmpty()) {
			shark temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int r = temp.dist;
			if (map[x][y] == 1) {
				return r;
			}
			for (int i = 0; i < 8; i++) {
				if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m)
					if (!vis[x + dx[i]][y + dy[i]]) {
						q.offer(new shark(x + dx[i], y + dy[i], r + 1));
						vis[x + dx[i]][y + dy[i]] = true;
					}
			}
		}
		return 0;
	}
}

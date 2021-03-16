package algo0316;

import java.io.*;
import java.util.*;

public class BOJ_13549 {
	static int n, m, max;
	static Queue<int[]> q;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = Integer.MAX_VALUE;
		vis = new boolean[100002];
		q = new LinkedList<>();
		q.offer(new int[] { n, 0 });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[0] == m) {
				System.out.println(Math.min(max, temp[1]));
				break;
			}
			if (vis[temp[0]]) continue;
			vis[temp[0]] = true;
			if (temp[0] - 1 >= 0 && !vis[temp[0] - 1])
				q.offer(new int[] { temp[0] - 1, temp[1] + 1 });
			if (temp[0] * 2 <= 100000 && !vis[temp[0] * 2])
				q.offer(new int[] { temp[0] * 2, temp[1] });
			if (temp[0] + 1 <= 100000 && !vis[temp[0] + 1])
				q.offer(new int[] { temp[0] + 1, temp[1] + 1 });

		}
	}
}

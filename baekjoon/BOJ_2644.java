import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {
	static int n, m, a, b;
	static boolean[] vis;
	static int ans = -1;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		vis = new boolean[n+1];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		DFS(a, 0);
		System.out.println(ans);
	}

	public static void DFS(int a, int cnt) {
		vis[a] = true;
		if (a == b) {
			ans = cnt;
			return;
		}
		for (int i = 0; i < list.get(a).size(); i++) {
			if (!vis[list.get(a).get(i)]) {
				DFS(list.get(a).get(i), cnt + 1);
			}
		}
	}
}

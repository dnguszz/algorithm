package algo0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5567 {
	static int n, m;
	static ArrayList<ArrayList<Integer>> fri;
	static boolean[] check;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		fri = new ArrayList<>();
		check = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			fri.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			fri.get(from).add(to);
			fri.get(to).add(from);
		}
		check[1] = true;
		for (int i = 0; i < fri.get(1).size(); i++) {
			if (!check[fri.get(1).get(i)]) {
				check[fri.get(1).get(i)] = true;
				ans++;
			}
			for (int j = 0; j < fri.get(fri.get(1).get(i)).size(); j++) {
				if (!check[fri.get(fri.get(1).get(i)).get(j)]) {
					check[fri.get(fri.get(1).get(i)).get(j)] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
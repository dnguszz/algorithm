package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	// 1. 팀을 맺지 못한사람만 찾는거임 = 처음부터 끝까지 한명씩 맺어진거 확인하는 알고리즘( O(n^2) ) 으로 풀이가능 = n이
	// 10만이라 불가능
	// 2. DFS = 일반적인 DFS돌리면 위에처럼 O(n^2)나옴 => DFS를 돌릴 필요가 없는 노드를 찾아야한다.

	static int n, ans;
	static boolean[] vis, haveTo;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= test; tc++) {
			n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr = new int[n + 1];
			ans=0;
			vis = new boolean[n + 1];
			haveTo = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				DFS(i);
			}
			System.out.println(n-ans);
		}
	}

	public static void DFS(int st) {
		if (vis[st])
			return;
		vis[st] = true;
		int next = arr[st];
		if (!vis[next])
			DFS(next);
		else {
			if (!haveTo[next]) {
				ans++;
				for (int i = next; i != st; i = arr[i]) {
					ans++;
				}
			}
		}
		haveTo[st] = true;
	}
}

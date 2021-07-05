package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	// 1. ���� ���� ���ѻ���� ã�°��� = ó������ ������ �Ѹ� �ξ����� Ȯ���ϴ� �˰���( O(n^2) ) ���� Ǯ�̰��� = n��
	// 10���̶� �Ұ���
	// 2. DFS = �Ϲ����� DFS������ ����ó�� O(n^2)���� => DFS�� ���� �ʿ䰡 ���� ��带 ã�ƾ��Ѵ�.

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

package algo0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KOI_2577 {
	static int n, d, k, c;
	static int[] bob;
	static int[] jong;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		bob = new int[2 * n];
		jong = new int[d + 1];
		for (int i = 0; i < n; i++) {
			bob[i] = Integer.parseInt(bf.readLine());
		}
		for (int i = 0; i < n; i++) {
			bob[n + i] = bob[i];
		}
		int eat = 0;
		for (int i = 0; i < k; i++) {
			if (jong[bob[i]]++ == 0) {
				eat++;
			}
		}
		if (jong[c] == 0)
			eat++;
		ans = Math.max(eat, ans);
		if (jong[c] == 0)
			eat--;
		int front = 0;
		for (int i = 1; i < n; i++) {
			if (--jong[bob[front]] == 0) {
				eat--;
			}
			if (jong[bob[(i + k - 1) % n]]++ == 0) {
				eat++;
			}
			if (jong[c] == 0)
				eat++;
			ans = Math.max(eat, ans);
			if (jong[c] == 0)
				eat--;
			front++;
		}
		System.out.println(ans);
	}
}

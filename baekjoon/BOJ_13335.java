import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
	static int n, w, l;
	static int[] truck;
	static Queue<Integer> q = new LinkedList<>();
	static int weight;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		truck = new int[n];
		weight = 0;
		ans = 0;
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			while (true) {
				if (q.size() == w) {
					weight -= q.peek();
					q.poll();
				}
				if (truck[i] + weight <= l)
					break;
				q.offer(0);
				ans++;
			}
			q.offer(truck[i]);
			weight += truck[i];
			ans++;
		}
		System.out.println(ans+w);

	}
}

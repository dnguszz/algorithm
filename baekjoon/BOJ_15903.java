import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
	static int n, m;
	static PriorityQueue<Long> pq;
	static long ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			long temp = pq.poll()+pq.poll();
			pq.offer(temp);
			pq.offer(temp);
		}
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
		System.out.println(ans);
	}
}

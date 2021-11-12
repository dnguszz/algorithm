import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2012 {
	static int n;
	static PriorityQueue<Integer> pq;
	static long ans=0;
	static int rank=1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<>();
		n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(bf.readLine()));
		}
		for (int i = 0; i < n; i++) {
			ans+=Math.abs(pq.poll()-rank++);
		}
		System.out.println(ans);
	}
}

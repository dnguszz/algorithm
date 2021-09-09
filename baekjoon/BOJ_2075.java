import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
	static int n;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < n-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}

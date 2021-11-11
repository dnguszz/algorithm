import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9237 {
	static int n;
	static PriorityQueue<Integer> pq;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		pq = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		int day=0;
		while(!pq.isEmpty()) {
			day++;
			int temp = pq.poll()+day;
			if(temp>ans) ans=temp;
		}
		System.out.println(ans+1);
		
	}
}

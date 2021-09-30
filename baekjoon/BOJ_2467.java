import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2467 {
	static int n;
	static int[] arr;
	static int val = Integer.MAX_VALUE;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int start=0;
		int end=n-1;
		while(start<end) {
			int temp = arr[start]+arr[end];
			if(Math.abs(temp)<val) {
				val = Math.abs(temp);
				if(!pq.isEmpty()) {
					pq.poll();
					pq.poll();
					pq.offer(start);
					pq.offer(end);
				}
				else {
					pq.offer(start);
					pq.offer(end);
				}
			}
			if(temp==0) {
				if(!pq.isEmpty()) {
					pq.poll();
					pq.poll();
					pq.offer(start);
					pq.offer(end);
				}
				else {
					pq.offer(start);
					pq.offer(end);
				}
				break;
			}
			if(temp>0) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(arr[pq.poll()]+" "+arr[pq.poll()]);
	}
}

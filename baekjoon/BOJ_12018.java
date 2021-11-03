import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12018 {
	static int n, m, p, l;
	static PriorityQueue<Integer> pq;
	static int[] arr;
	static int ans=0;
	static int val=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(bf.readLine());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			if(p<l) {
				st = new StringTokenizer(bf.readLine());
				arr[i]=1;
				continue;
			}
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < p; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			for (int j = 0; j < l-1; j++) {
				pq.poll();
			}
			arr[i]=pq.poll();
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if(val+arr[i]<=m) {
				ans++;
				val+=arr[i];
			}
			else break;
		}
		System.out.println(ans);
	}
}

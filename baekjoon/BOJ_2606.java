import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
	static int n, m;
	static boolean[] vis;
	static int ans=-1;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		list = new ArrayList<>();
		vis = new boolean[n+1];
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list.get(to).add(from);
			list.get(from).add(to);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		vis[1]=true;
		while(!q.isEmpty()) {
			ans++;
			int temp = q.poll();
			for (int i = 0; i < list.get(temp).size(); i++) {
				int b = list.get(temp).get(i);
				if(!vis[b]) {
					q.offer(b);
					vis[b]=true;
				}
			}
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496 {
	static int a, b;
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] vis;
	static int ans=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		vis = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a,0});
		vis[a]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp[0]==b) {
				ans=temp[1];
				break;
			}
			for (int i = 0; i < list[temp[0]].size(); i++) {
				int val = list[temp[0]].get(i);
				if(!vis[val]) {
					q.offer(new int[] {val, temp[1]+1});
					vis[val]=true;
				}
			}
		}
		System.out.println(ans);
	}
}

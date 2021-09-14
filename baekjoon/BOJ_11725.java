import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
	static int n;
	static int[] parent;
	static boolean[] vis;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		parent = new int[n+1];
		vis = new boolean[n+1];
		adj = new ArrayList[n+1];
		for (int i = 1; i < n+1; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		vis[1]=true;
		while(!q.isEmpty()) {
			int dist = q.poll();
			for (int i = 0; i < adj[dist].size(); i++) {
				if(!vis[adj[dist].get(i)]) {
					parent[adj[dist].get(i)]=dist;
					vis[adj[dist].get(i)]=true;
					q.offer(adj[dist].get(i));
				}
			}
		}
		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
	}
}

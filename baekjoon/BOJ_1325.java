import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
	static int n, m;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] vis;
	static int cnt;
	static int max=-1;
	static int[] rank;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		list = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rank = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}
		for (int i = 1; i < n+1; i++) {
			vis = new boolean[n+1];
			cnt=0;
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			vis[i]=true;
			while(!q.isEmpty()) {
				cnt++;
				int temp = q.poll();
				for (int j = 0; j < list.get(temp).size(); j++) {
					int x = list.get(temp).get(j);
					if(!vis[x]) {
						vis[x]=true;
						rank[x]++;
						q.offer(x);
					}
				}
			}
		}
		for(int i=1; i<n+1; i++) {
			max = Math.max(rank[i], max);
		}
		
		for(int i=1; i<n+1; i++) {
			if(max == rank[i]) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	static int n, m;
	static int min = Integer.MAX_VALUE;
	static int ansIndex=Integer.MAX_VALUE;
	static int[] tempIndex;
	static boolean[] vis;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		tempIndex=new int[n+1];
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list.get(to).add(from);
			list.get(from).add(to);
		}
		
		for (int i = 1; i < n+1; i++) {
			vis = new boolean[n+1];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {i,0});
			vis[i]=true;
			int ans=0;
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int a = temp[0];
				int b = temp[1];
				for (int j = 0; j < list.get(a).size(); j++) {
					int tt = list.get(a).get(j);
					if(!vis[tt]) {
						q.offer(new int[] {tt,b+1});
						ans+=b+1;
						vis[tt]=true;
					}
				}
			}
			tempIndex[i]=ans;
			if(ans<min) {
				min=ans;
			}
		}
		for (int i = 1; i < n+1; i++) {
			if(tempIndex[i]==min && i<ansIndex) {
				ansIndex=i;
			}
		}
		System.out.println(ansIndex);
	}
}

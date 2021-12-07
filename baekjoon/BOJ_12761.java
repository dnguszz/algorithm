import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761 {
	static int a, b, n, m;
	static int[] move;
	static int ans;
	static boolean[] vis;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		move = new int[6];
		move[0]=-1;
		move[1]=1;
		move[2]=a;
		move[3]=b;
		move[4]=-a;
		move[5]=-b;
		vis = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		vis[n]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int now = temp[0];
			int cnt = temp[1];
			if(now==m) {
				ans=cnt;
				break;
			}
			for (int i = 0; i < 6; i++) {
				if(now+move[i]>0 && now+move[i]<=100000 && !vis[now+move[i]]) {
					q.offer(new int[] {now+move[i], cnt+1});
					vis[now+move[i]]=true;
				}
			}
			if(now*a>0 && now*a<=100000 && !vis[now*a]) {
				q.offer(new int[] {now*a, cnt+1});
				vis[now*a]=true;
			}
			if(now*b>0 && now*b<=100000 && !vis[now*b]) {
				q.offer(new int[] {now*b, cnt+1});
				vis[now*b]=true;
			}
		}
		System.out.println(ans);
	}
}

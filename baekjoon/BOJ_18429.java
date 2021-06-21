import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18429 {
	static int n, k;
	static int[] lack;
	static int[] arr;
	static boolean[] vis;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		lack = new int[n];
		arr = new int[n];
		vis = new boolean[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			lack[i]=Integer.parseInt(st.nextToken());
		}
		P(0);
		System.out.println(ans);
	}
	
	public static void P(int cnt) {
		if(cnt==n) {
			int three = 500;
			for (int i = 0; i < n; i++) {
				three+=lack[arr[i]];
				three-=k;
				if(three<500) return;
			}
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(vis[i]) continue;
			arr[i]=cnt;
			vis[i]=true;
			P(cnt+1);
			vis[i]=false;
		}
	}
}

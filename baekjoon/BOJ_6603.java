import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int n;
	static int[] arr;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			arr = new int[n];
			ans = new int[n];
			for (int i = 0; i < n ; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			C(0,0);
			System.out.println();
		}
	}
	
	private static void C(int start,int cnt) {
		if(cnt==6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			 ans[cnt]=arr[i];
			 C(i+1, cnt+1);
		}
	}
}

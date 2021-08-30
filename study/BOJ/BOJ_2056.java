import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2056 {
	static int n;
	static int[] work;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		work = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int time = Integer.parseInt(st.nextToken());
			int max=0;
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(work[temp]>max) max=work[temp];
			}
			work[i]=max+time;
			if(work[i]>ans) ans=work[i];
		}
		System.out.println(ans);
	}
}

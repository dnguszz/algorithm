import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026 {
	static int n;
	static int[] a, b;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n];
		b = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < n; i++) {
			ans+=a[i]*b[n-1-i];
		}
		System.out.println(ans);
	}
}

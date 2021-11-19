import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20044 {
	static int n;
	static int[] arr;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[2*n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 2*n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			ans=Math.min(ans, arr[i]+arr[2*n-1-i]);
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300 {
	static int n;
	static long[] arr;
	static long ans=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		if(n%2==0) {
			for (int i = 0; i < n/2; i++) {
				long temp = arr[i]+arr[n-1-i];
				if(temp>ans) ans=temp;
			}
		}
		else {
			for (int i = 0; i < n-2; i++) {
				long temp = arr[i]+arr[n-2-i];
				if(temp>ans) ans=temp;
			}
			if(ans<arr[n-1]) {
				ans=arr[n-1];
			}
		}
		System.out.println(ans);
	}
}

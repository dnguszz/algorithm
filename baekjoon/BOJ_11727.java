import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
	static int n;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new long[1001];
		arr[1]=1;
		arr[2]=3;
		for (int i = 3; i <= n; i++) {
			arr[i]=((arr[i-2]*2)+arr[i-1])%10007;
		}
		System.out.println(arr[n]);
	}
}

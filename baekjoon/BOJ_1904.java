import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {
	static int n;
	static long arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new long[1000001];
		arr[0]=1;
		arr[1]=2;
		for(int i =2 ; i<n ;i++) {
			arr[i]=(arr[i-2]+arr[i-1])%15746;
		}
		System.out.println(arr[n-1]);

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579 {
	static int n;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		if(n<3) {
			switch (n) {
			case 1:
				System.out.println(arr[0]);
				break;
			case 2:
				System.out.println(Math.max(arr[0]+arr[1],arr[1]));
				break;
			default:
				break;
			}
	    	System.exit(0);
	    }
		dp[0]=arr[0];
		dp[1] = Math.max(arr[0]+arr[1],arr[1]);
	    dp[2] = Math.max(arr[0]+arr[2],arr[1]+arr[2]);
	    
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]);

		}
		System.out.println(dp[n-1]);
	}
}

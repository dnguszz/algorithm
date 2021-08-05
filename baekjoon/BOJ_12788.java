import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12788 {
	static int n, sum;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		sum = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int temp=0;
		for (int i = n-1; i >= 0; i--) {
			temp+=arr[i];
			if(temp>=sum) {
				System.out.println(n-i);
				System.exit(0);
			}
		}
		System.out.println("STRESS");
	}
}

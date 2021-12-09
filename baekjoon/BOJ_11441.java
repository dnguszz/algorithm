import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11441 {
	static int n, m;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr[0]=0;
		for (int i = 1; i < n+1; i++) {
			int temp=Integer.parseInt(st.nextToken());
			arr[i]=arr[i-1]+temp;
		}
		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(arr[b]-arr[a-1]);
		}
	}
}

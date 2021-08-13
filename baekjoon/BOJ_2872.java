import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2872 {
	static int n, ans;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		ans=n;
		for (int i = n-1; i >= 0; i--) {
			if (arr[i] == ans)
				ans--;
		}
		System.out.println(ans);
	}
}

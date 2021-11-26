import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20413 {
	static int n;
	static int b, s, g, p, d;
	static int ans = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		b = 0;
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		String mvp = bf.readLine();
		int lastMonth = 0;
		for (int i = 0; i < n; i++) {
			switch (mvp.charAt(i)) {
			case ('B'):
				arr[i] = s - 1 - lastMonth;
				break;
			case ('S'):
				arr[i] = g - 1 - lastMonth;
				break;
			case ('G'):
				arr[i] = p - 1 - lastMonth;
				break;
			case ('P'):
				arr[i] = d - 1 - lastMonth;
				break;
			case ('D'):
				arr[i] = d;
				break;
			}
			lastMonth=arr[i];
			ans+=arr[i];
		}
		System.out.println(ans);
	}
}

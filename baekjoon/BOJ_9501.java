import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9501 {
	static int n, d;
	static int[][] arr;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			ans = 0 ;
			arr = new int[n][3];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				double v = Double.parseDouble(st.nextToken());
				double f = Double.parseDouble(st.nextToken());
				double c = Double.parseDouble(st.nextToken());
				
				double time = (double) d / v;
				if(time*c <= f) ans++;
				
			}
			System.out.println(ans);
		}
	}
}

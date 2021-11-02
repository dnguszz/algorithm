import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720 {
	static int test;
	static int val;
	static int ans[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			ans = new int[4];
			val  = Integer.parseInt(bf.readLine());
			while(val>=25) {
				val-=25;
				ans[0]++;
			}
			while(val>=10) {
				val-=10;
				ans[1]++;
			}
			while(val>=5) {
				val-=5;
				ans[2]++;
			}
			while(val>=1) {
				val-=1;
				ans[3]++;
			}
			System.out.println(ans[0]+" "+ans[1]+" "+ans[2]+' '+ans[3]);
		}
	}
}

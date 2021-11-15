import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12782 {
	static int test;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			arr = new int[2];
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i)!=b.charAt(i)) {
					if(a.charAt(i)=='0') {
						arr[0]++;
					}
					else {
						arr[1]++;
					}
				}
			}
			System.out.println(Math.max(arr[0], arr[1]));
		}
	}
}

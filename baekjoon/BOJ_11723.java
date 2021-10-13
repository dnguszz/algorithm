import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11723 {
	static int m;
	static int bit = 0;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String oper = st.nextToken();
			if (oper.equals("add")) {
				int to = Integer.parseInt(st.nextToken());
				bit = bit | (1 << to - 1);

			} else if (oper.equals("remove")) {
				int to = Integer.parseInt(st.nextToken());
				bit = bit & ~(1 << to - 1);

			} else if (oper.equals("check")) {
				int to = Integer.parseInt(st.nextToken());
				sb.append((bit & (1 << to - 1)) != 0 ? "1\n" : "0\n");

			} else if (oper.equals("toggle")) {
				int to = Integer.parseInt(st.nextToken());
				bit = bit ^ (1 << (to - 1));

			} else if (oper.equals("all")) {
				bit = Integer.MAX_VALUE;

			} else if (oper.equals("empty")) {
				bit=0;
			}
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
	static int n, m;
	static HashMap<String, String> hm;
	static StringBuffer sb;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		hm = new HashMap<>();
		sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			hm.put(st.nextToken(), st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			sb.append(hm.get(bf.readLine())+"\n");
		}
		System.out.println(sb.toString());
	}
}

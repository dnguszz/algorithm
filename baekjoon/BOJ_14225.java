import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_14425 {
	static int n, m;
	static HashMap<String, Boolean> hs;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		hs = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hs.put(bf.readLine(), true);
		}
		for (int i = 0; i < m; i++) {
			if(hs.get(bf.readLine())!=null) ans++;
		}
		System.out.println(ans);
	}
}

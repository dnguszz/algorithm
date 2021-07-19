import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
	static int e, s, m, ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		e = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans=1;
		while(true) {
			if((ans-e)%15==0 && (ans-s)%28==0 && (ans-m)%19==0) break;
			ans++;
		}
		System.out.println(ans);
	}
}

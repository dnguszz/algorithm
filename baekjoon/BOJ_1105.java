import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
	static String l, r;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		l=st.nextToken();
		r=st.nextToken();
		if(l.length() != r.length()) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 0; i < l.length(); i++) {
			if(l.charAt(i) == r.charAt(i)) {
				if(l.charAt(i) == '8') ans++;
            }
			else break;
		}
	System.out.println(ans);
	}	
}

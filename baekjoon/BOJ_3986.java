import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {
	static int n;
	static int ans = 0;
	static String s;
	static Stack<Character> st;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			s = bf.readLine();
			st = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				if (!st.isEmpty() && st.peek() == s.charAt(j))
					st.pop();
				else
					st.push(s.charAt(j));
			}
			if(st.isEmpty()) ans++;
		}
		System.out.println(ans);
	}
}

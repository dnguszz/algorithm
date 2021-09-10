import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952 {
	static int n;
	static Stack<int[]> stack;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			if(st.nextToken().equals("0")) ;
			else stack.push(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			if(!stack.isEmpty()) {
				stack.peek()[1]--;
				if(stack.peek()[1]==0) {
					ans+=stack.peek()[0];
					stack.pop();
				}
			}
		}
		System.out.println(ans);
	}
}

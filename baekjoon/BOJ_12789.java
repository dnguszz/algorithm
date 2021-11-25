import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789 {
	static Stack<Integer> stack;
	static Queue<Integer> q;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		q = new LinkedList<>();
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		int cnt=1;
		boolean flag=true;
		while(!q.isEmpty() || !stack.isEmpty()) {
			if(!stack.isEmpty() && stack.peek()==cnt) {
				stack.pop();
				cnt++;
			}
			else if(!q.isEmpty() && q.peek()==cnt) {
				q.poll();
				cnt++;
			}
			else {
				if(!q.isEmpty()) {
					stack.push(q.poll());
				}
				else {
					flag=false;
					break;
				}
			}
		}
		System.out.println(flag ? "Nice" : "Sad");
	}
}

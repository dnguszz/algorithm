import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15828 {
	static int n;
	static int buf=0;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		q = new LinkedList<>();
		while(true) {
			int oper = Integer.parseInt(bf.readLine());
			if(oper==-1) break;
			if(oper==0) {
				q.poll();
				buf--;
			}
			else {
				if(buf<n) {
					q.offer(oper);
					buf++;
				}
			}
		}
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
	}
}

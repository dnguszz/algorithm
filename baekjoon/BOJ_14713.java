import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14713 {
	static int n;
	static Queue<String> l;
	static Queue<String> bird[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		bird = new Queue[n];
		l = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			bird[i]=new LinkedList<>();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			while(st.hasMoreTokens()) {
				bird[i].offer(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		while(st.hasMoreTokens()) {
			l.offer(st.nextToken());
		}
		while(!l.isEmpty()) {
			String temp = l.peek();
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if(!bird[i].isEmpty()) {
					if(bird[i].peek().equals(temp)) {
						flag=true;
						l.poll();
						bird[i].poll();
						break;
					}
				}
			}
			if(!flag) {
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		for (int i = 0; i < n; i++) {
			if(!bird[i].isEmpty()) {
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		System.out.println("Possible");
	}
}

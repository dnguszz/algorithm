import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
	static int n, l;
	static int cnt, start=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 100; i++) {
			if((n-((i*(i-1))/2))%i==0 && i>=l) {
				cnt=i;
				start=(n-((i*(i-1))/2))/i;
				break;
			}
		}
		if(start<0) {
			System.out.println(-1);
		}
		else {
			for (int i = 0; i < cnt; i++) {
				System.out.print(start+i+" ");
			}
		}
	}
}

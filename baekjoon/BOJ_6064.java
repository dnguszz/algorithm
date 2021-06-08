import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
	static int M, N, x, y;
	static long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ans = 0;
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int tempX=x;
			int tempY=0;
			boolean flag=true;
			int gbs=(M*N)/gcd(M,N);
			int count=0;
			while(true) {				
				tempX=x+(M*count);
				tempY=(x+(M*count))%N;
				if(tempY==0) tempY=N;
				if(tempY==y) break;
				if(tempX > gbs) {
					flag=false;
					break;
				}
				count++;
			}
			System.out.println(flag ? tempX : -1);
		}
	}
	
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;  
			a = b;
			b = r;
		}
		return a;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
	static int N, r, c;
	static long ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ans=0;
		N=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		z(N);
		System.out.println(ans);
	}
	
	public static void z(int n) {
		if(n==0) return;
		else {
			int t = (int) Math.pow(2, n); //t는 변의길이
			int x, y;
			if(r>=t/2) y=1;
			else y=0;
			if(c>=t/2) x=1;
			else x=0;
			if(x==0 && y==0) {
				ans+=0*Math.pow(2, 2*n-2);
			}
			else if(x==1 && y==0) {
				ans+=1*Math.pow(2, 2*n-2);
				c-=t/2;
			}
			else if(x==0 && y==1) {
				ans+=2*Math.pow(2, 2*n-2);
				r-=t/2;
			}
			else { //1,1
				ans+=3*Math.pow(2, 2*n-2);
				r-=t/2;
				c-=t/2;
			}
			z(n-1);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
	static int n;
	static int a, b, c;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		ans = new int[3];
		if(n%10!=0) {
			System.out.println(-1);
			System.exit(0);
		}
		a=300;
		b=60;
		c=10;
		while(true) {
			if(n/a==0) break;
			n-=a;
			ans[0]++;
		}
		while(true) {
			if(n/b==0) break;
			n-=b;
			ans[1]++;
		}
		while(true) {
			if(n/c==0) break;
			n-=c;
			ans[2]++;
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}

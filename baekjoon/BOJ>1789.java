import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
	static long n;
	static long ans=0;
	static long cnt=1;
	static long temp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(bf.readLine());
		while(true) {
			temp+=cnt;
			ans++;
			if(temp>=n) break;
			cnt++;
		}
		System.out.println(ans-1);
	}
}

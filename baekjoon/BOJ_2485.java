import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2485 {
	static int n;
	static int[] arr;
	static int[] cha;
	static int gcd;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		cha = new int[n-1];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
			if(i>0) cha[i-1]=arr[i]-arr[i-1];
		}
		gcd = getGCD(cha[0], cha[1]);
		for (int i = 2; i < cha.length; i++) {
			gcd = getGCD(gcd, cha[i]);
		}
		for (int i = 0; i < cha.length; i++) {
			ans+=(cha[i]/gcd)-1;
		}
		System.out.println(ans);
	}
	
	public static int getGCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}

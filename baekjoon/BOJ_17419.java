import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17419 {
	static int n;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String temp = bf.readLine();
		for (int i = 0; i < n; i++) {
			if(temp.charAt(i)=='1') {
				ans++;
			}
		}
		System.out.println(ans);
	}
}

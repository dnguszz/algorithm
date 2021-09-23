import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
	static String a, b;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		a = bf.readLine();
		b = bf.readLine();
		for (int i = 0; i < a.length(); i++) {
			boolean flag=true;
			for (int j = 0; j < b.length(); j++) {
				if(i+j>=a.length() || a.charAt(i+j)!=b.charAt(j)) {
					flag=false;
					break;
				}
			}
			if(flag) {
				ans++;
				i+=b.length()-1;
			}
		}
		System.out.println(ans);
	}
}

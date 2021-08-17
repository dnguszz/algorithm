import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		char temp=s.charAt(0);
		int one=0;
		int zero=0;
		if(temp=='0') {
			zero++;
		}
		else {
			one++;
		}
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)!=temp) {
				temp=s.charAt(i);
				if(temp=='1') {
					one++;
				}
				else {
					zero++;
				}
			}
		}
		System.out.println(Math.min(one, zero));
	}
}

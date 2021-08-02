import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15927 {
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s=bf.readLine();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
				System.out.println(s.length());
				System.exit(0);
			}
		}
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)!=s.charAt(0)) {
				System.out.println(s.length()-1);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15904 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		if(s.contains("U")) {
			s=s.substring(s.indexOf("U")+1);
		}
		else {
			System.out.println("I hate UCPC");
			System.exit(0);
		}
		if(s.contains("C")) {
			s=s.substring(s.indexOf("C")+1);
		}
		else {
			System.out.println("I hate UCPC");
			System.exit(0);
		}
		if(s.contains("P")) {
			s=s.substring(s.indexOf("P")+1);
		}
		else {
			System.out.println("I hate UCPC");
			System.exit(0);
		}
		if(s.contains("C")) {
			s=s.substring(s.indexOf("C")+1);
		}
		else {
			System.out.println("I hate UCPC");
			System.exit(0);
		}
		System.out.println("I love UCPC");
	}
}

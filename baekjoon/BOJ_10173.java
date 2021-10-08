import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10173 {
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(!(s=bf.readLine()).equals("EOI")) {
			s=s.toUpperCase();
			System.out.println(s.matches(".*(NEMO).*") ? "Found" : "Missing");
		}
	}
}

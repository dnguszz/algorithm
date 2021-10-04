import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14405 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		if(s.matches("(pi|ka|chu)*")) {
			System.out.println("YES");
		}
		else System.out.println("NO");
	}
}

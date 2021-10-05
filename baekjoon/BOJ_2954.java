import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2954 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(bf.readLine().replaceAll("(?:([a|e|i|o|u]{1})(p{1})([a|e|i|o|u{1}]))", "$1"));
	}
}

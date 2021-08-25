import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2877 {
	static int k;
	static String sk;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(bf.readLine());
		k++;
		sk = Integer.toBinaryString(k);
		sk=sk.substring(1);
		for (int i = 0; i < sk.length(); i++) {
			System.out.print(sk.charAt(i)=='0' ? 4 : 7 );
		}
	}
}

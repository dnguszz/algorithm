import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2716 {
	static int test;
	static String tree;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			tree = bf.readLine();
			int cnt=0;
			int max=0;
			for (int i = 0; i < tree.length(); i++) {
				if(tree.charAt(i)=='[') {
					cnt++;
					if(cnt>max) max=cnt;
				}
				else cnt--;
			}
			System.out.println((int) Math.pow(2, max));
		}
	}
}

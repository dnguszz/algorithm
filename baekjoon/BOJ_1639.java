import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1639 {
	static String s;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s=bf.readLine();
		int size=2;
		ans=-1;
		while(size<=s.length()) {
			for (int i = 0; i <= s.length()-size; i++) {
				int temp = func(s.substring(i, i+size));
				if(temp>ans) ans=temp;
			}
			size+=2;
		}
		System.out.println(ans!=-1 ? ans : 0);
	}
	
	public static int func(String s) {
		int a,b;
		a=0;
		b=0;
		for (int i = 0; i < s.length()/2; i++) {
			a+=s.charAt(i);
			b+=s.charAt(s.length()-1-i);
		}
		if(a==b) return s.length();
		return -1;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_1264 {
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile("[aeiouAEIOU]");
		while(true) {
			String s = bf.readLine();
			if(s.equals("#")) break;
			Matcher matcher = pattern.matcher(s);
			ans=0;
            while (matcher.find()) {
                ans++;
            }
            System.out.println(ans);
		}
	}
}

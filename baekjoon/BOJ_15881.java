import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_15881 {
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bf.readLine();
		Pattern pattern = Pattern.compile("pPAp");
        Matcher matcher = pattern.matcher(bf.readLine());
        while (matcher.find()) {
            ans++;
        }
		System.out.println(ans);
		
	}
}

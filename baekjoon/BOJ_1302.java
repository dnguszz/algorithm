import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_1302 {
	static int n;
	static ArrayList<String> ans;
	static HashMap<String, Integer> hs;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		ans = new ArrayList<>();
		hs = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String temp = bf.readLine();
			if(hs.get(temp)==null) {
				hs.put(temp, 1);
			}
			else {
				hs.put(temp, hs.get(temp)+1);
			}
		}
		int max=-1;
		for (HashMap.Entry<String, Integer> entry : hs.entrySet()) {
			if(entry.getValue()>max) {
				max = entry.getValue();
			}
	    }
		for (HashMap.Entry<String, Integer> entry : hs.entrySet()) {
			if(entry.getValue()==max) {
				ans.add(entry.getKey());
			}
	    }
		Collections.sort(ans);
		System.out.println(ans.get(0));
	}
}

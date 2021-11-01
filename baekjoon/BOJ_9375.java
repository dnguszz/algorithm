import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static int n;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for(int wq = 0 ; wq<n ; wq++) {
			HashMap<String, Integer> map = new HashMap<>();
			String nns = bf.readLine();
			int casenum = Integer.parseInt(nns);
			String[] wear = new String[casenum];
			for(int i=0 ; i<casenum ; i++) {
				wear[i]=bf.readLine();
				wear[i]=wear[i].split(" ")[1];
				Integer val = map.get(wear[i]);
				if(val==null) val=1;
				else val+=1;
				map.put(wear[i], val);		
			}
			ans=1;
			for(int val : map.values()) {
				ans*=(val+1);
			}
			System.out.println(ans-1);
		}
	}
}

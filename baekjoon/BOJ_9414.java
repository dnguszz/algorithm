import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_9414 {
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int test = 0; test < tc; test++) {
			list = new ArrayList<>();
			while(true) {
				int temp = Integer.parseInt(bf.readLine());
				if(temp==0) break;
				list.add(temp);
			}
			Collections.sort(list, Collections.reverseOrder());
			int cnt=1;
			long ans=0;
			for (int i = 0; i < list.size(); i++) {
				ans+=Math.pow(list.get(i), cnt++);
			}
			System.out.println(ans*2<=5000000 ? ans*2 : "Too expensive");
		}
	}
}

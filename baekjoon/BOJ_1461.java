import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1461 {
	static int n, m;
	static int[] arr;
	static ArrayList<Integer> pos, neg, max;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pos = new ArrayList<>();
		neg = new ArrayList<>();
		max = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp>0) pos.add(temp);
			else neg.add(temp*-1);
		}
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg, Collections.reverseOrder());
		int index_p=0;
		boolean exit_p=false;
		while(index_p<pos.size()) {
			int big = -9999;
			for (int i = 0; i < m; i++) {
				if(i+index_p>=pos.size()) {
					exit_p=true;
					break;
				}
				if(pos.get(i+index_p)>big) big=pos.get(i+index_p);
			}
			max.add(big);
			if(exit_p) break;
			index_p+=m;
		}
		int index_n=0;
		boolean exit_n=false;
		while(index_n<neg.size()) {
			int big = -9999;
			for (int i = 0; i < m; i++) {
				if(i+index_n>=neg.size()) {
					exit_n=true;
					break;
				}
				if(neg.get(i+index_n)>big) big=neg.get(i+index_n);
			}
			max.add(big);
			if(exit_n) break;
			index_n+=m;
		}
		int temp_max = Collections.max(max);
		max.remove((Integer) temp_max);
		for (int i = 0; i < max.size(); i++) {
			ans+=(max.get(i)*2);
		}
		ans+=temp_max;
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2635 {
	static int n;
	static ArrayList<Integer> max, temp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		max = new ArrayList<>();
		max.add(n);
		max.add(1);
		int cnt=0;
		while(true) {
			int temp = max.get(cnt)-max.get(cnt+1);
			if(temp<0) break;
			else {
				max.add(temp);
				cnt++;
			}
		}
		for (int i = 2; i < n; i++) {
			temp = new ArrayList<>();
			temp.add(n);
			temp.add(i);
			cnt = 0;
			while(true) {
				int tempI = temp.get(cnt)-temp.get(cnt+1);
				if(tempI<0) break;
				else {
					temp.add(tempI);
					cnt++;
				}
			}
			if(temp.size()>max.size()) {
				max = new ArrayList<>();
				max.addAll(temp);
			}
		}
		System.out.println(max.size());
		for (int i = 0; i < max.size(); i++) {
			System.out.print(max.get(i)+" ");
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16206 {
	static int n, m;
	static int ans = 0;
	static ArrayList<Integer> arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList<>();
		arr2 = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp % 10 == 0)
				arr1.add(temp);
			else
				arr2.add(temp);
		}
		Collections.sort(arr1);
		while (true) {
			boolean flag = true;
			if (arr1.isEmpty())
				break;
			if (m < 1)
				break;
			for (int i = 0; i < arr1.get(0) / 10; i++) {
				if (i != 0)
					m--;
				if (m < 1) {
					if(i==(arr1.get(0)/10)-1) ans++;
					flag = false;
					break;
				}
				ans++;
			}
			if (!flag)
				break;
			arr1.remove(0);
		}
		while (true) {
			boolean flag = true;
			if (arr2.isEmpty())
				break;
			if (m < 1)
				break;
			for (int i = 0; i < arr2.get(0) / 10; i++) {
				ans++;
				m--;
				if (m < 1) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
			arr2.remove(0);
		}
		System.out.println(ans);
	}
}

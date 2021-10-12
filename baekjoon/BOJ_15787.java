import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_15787 {
	static int n, m;
	static int[] train;
	static HashMap<Integer, Integer> hs;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		hs = new HashMap<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		train = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				int oper1 = Integer.parseInt(st.nextToken());
				int dest1 = Integer.parseInt(st.nextToken());
				train[oper1] = train[oper1] | (1 << dest1);
				break;
			case 2:
				int oper2 = Integer.parseInt(st.nextToken());
				int dest2 = Integer.parseInt(st.nextToken());
				train[oper2] = train[oper2] & ~(1 << dest2);
				break;
			case 3:
				int oper3 = Integer.parseInt(st.nextToken());
				train[oper3] = train[oper3] << 1;
				train[oper3] = train[oper3] & ((1 << 21) - 1);
				break;
			case 4:
				int oper4 = Integer.parseInt(st.nextToken());
				train[oper4] = train[oper4] >> 1;
				train[oper4] = train[oper4] & ~1;
				break;
			default:
				break;
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			if(hs.get(train[i])==null) {
				hs.put(train[i], 1);
				ans++;
			}
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
	static int n, m;
	static int min, max;
	static int[] state;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		max = -9999;
		state = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			state[i]=Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			if(state[i]>max) max = state[i];
		}
		
		int sum=0;
		for (int i = 0; i < n; i++) {
			sum+=state[i];
		}
		if(sum < m) {
			System.out.println(max);
			System.exit(0);
		}
		int cut = max;
		while(true) {
			boolean flag = cal(cut);
			if(flag) {
				System.out.println(cut);
				break;
			}
			else cut--;
		}
	}
	
	public static boolean cal(int cut) {
		int sum=0;
		for (int i = 0; i < n; i++) {
			if(state[i]>cut) {
				sum+=cut;
			}
			else {
				sum+=state[i];
			}
		}
		if(sum>m) return false;
		else return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1980 {
	static int n, m,t, ansh, ansc;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		ansh=-9999999;
		ansc=9999999;
		for (int i = 0; i <= t/n; i++) {
			for (int j = 0; j <= t/m; j++) {
				int temp =( i*n )+( j*m );
				int sum = i+j;
				int cola = t-temp;
				if(cola>=0) {
					if(cola<ansc) {
						ansc=cola;
						ansh=sum;
					}
					if(cola==ansc) {
						if(sum>ansh) ansh=sum;
					}
				}
			}
		}
		System.out.print(ansh+" "+ansc);
	}
}

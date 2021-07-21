import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1487 {
	static int n, max;
	static int[][] arr;
	static int ans, index;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][2];
		max=-1;
		ans=-999999999;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			if(arr[i][0]>max) max = arr[i][0];
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= max; i++) {
			int temp=0;
			for (int j = 0; j < n; j++) {
				if(arr[j][0]>=i) {
					int tempP = i-arr[j][1];
					if(tempP>0)
					temp+=tempP;
				}
			}
			if(temp>ans) {
				ans=temp;
				index=i;
			}
		}
		System.out.println(ans>0 ? index : 0);
	}
}

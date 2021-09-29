import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			m = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				int temp=Integer.parseInt(st.nextToken());
				int start=0;
				int end=n-1;
				int mid;
				boolean flag=false;
				while(start<=end) {
					mid = (start+end)/2;
					if(arr[mid]==temp) {
						flag=true;
						break;
					}
					else if (arr[mid]<temp) {
						start=mid+1;
					}
					else {
						end=mid-1;
					}
				}
				sb.append(flag ? "1\n":"0\n");
				
			}
			System.out.print(sb);
		}
	}
}

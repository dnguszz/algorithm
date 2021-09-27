import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
	static int n, m;
	static int[] arr, val;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		m = Integer.parseInt(bf.readLine());
		val = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			val[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			int temp = val[i];
			int start=0;
			int end = n-1;
			int mid;
			boolean flag=false;
			while(start<=end) {
				mid = (start+end)/2;
				if(temp==arr[mid]) {
					flag=true;
					break;
				}
				else if(temp > arr[mid]) {
					start=mid+1;
				}
				else {
					end=mid-1;
				}
			}
			System.out.print(flag ? "1 " : "0 ");
		}
	}
}

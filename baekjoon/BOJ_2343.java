import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int start=1;
		int end = 1000000000;
		int mid;
		while(start<=end) {
			mid=(start+end)/2;
			if(rec(mid)) { //true
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		System.out.println(start);
	}
	
	public static boolean rec(int max) {
		int cnt=0;
		int val=1;
		for (int i = 0; i < n; i++) {
			cnt+=arr[i];
			if(arr[i]>max) return false;
			if(cnt>max) {
				val++;
				if(i==n-1) break;
				cnt=0;
				i--;
			}
		}
		if(val>m) return false;
		return true;
	}
}

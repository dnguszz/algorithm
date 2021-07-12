import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
	static int n, k;
	static int[] arr;
	static int ans=0;
	static int max=-1;
	static int start, end;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		start = 0;
		end = k-1;
		for (int i = 0; i <= end; i++) {
			ans+=arr[i];
		}
		max=ans;
		while(end<n) {
			if(end>=n-1) break;
			ans-=arr[start];
			ans+=arr[end+1];
			start++;
			end++;
			if(ans>max) max = ans;
		}
		System.out.println(max);
	}
}

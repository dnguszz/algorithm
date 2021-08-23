import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
	static int n;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int left, right;
	static int ans1, ans2;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		left=0;
		right=n-1;
		while(left!=right) {
			int temp = arr[left]+arr[right];
			if(Math.abs(temp)<Math.abs(min)) {
				min=temp;
				ans1=arr[left];
				ans2=arr[right];
			}
			if(temp==0) {
				System.out.println(arr[left]+" "+arr[right]);
				System.exit(0);
			}
			else if(temp>0) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.println(ans1+" "+ans2);
	}
}

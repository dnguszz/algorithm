import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2847 {
	static int n, temp, ans;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		ans=0;
		temp = arr[arr.length-1];
		for (int i = n-2; i >= 0; i--) {
			while(true) {
				if(arr[i]>=temp) {
					arr[i]--;
					ans++;
				}
				else {
					temp = arr[i];
					break;
				}
			}
		}
		System.out.println(ans);
	}
}

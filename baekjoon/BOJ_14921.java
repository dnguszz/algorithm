import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14921 {
	static int n;
	static int[] arr;
	static int right, left;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		left = 0;
		right = n-1;
		while(left<right) {
			int temp = arr[right]+arr[left];
			if(temp==0) {
				ans=temp;
				break;
			}
			//만약 지금값이 전보다 0에 더 근접하면 갱신
			if(Math.abs(temp)<Math.abs(ans)) {
				ans=temp;
			}
			if(temp<0) left++; //두 포인터 더한값이 음수라면 => 오른쪽을 1 줄이면 더작아짐(절대값 무조건커짐), 왼쪽을 1 늘리면 양수가 될수도 있지만 절대값이 작아질수도있음
			else right--; //반대의경우도
		}
		System.out.println(ans);
	}
}

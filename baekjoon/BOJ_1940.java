import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940 {
	static int n, m;
	static int[] arr;
	static int cnt=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=(Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<n; i++)  {
            int sum = 0;
            int end = i+1;
            while (end<n) {
                sum = arr[i];
                sum += arr[end++];
                if (sum == m) {
                    cnt++;
                    break;
                }
            }
        }
		System.out.println(cnt);
	}
}

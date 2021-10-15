import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11811 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(i!=j) {
					arr[i]=arr[i]|temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

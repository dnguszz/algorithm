import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10867 {
	static int n;
	static int[] arr;
	static HashMap<Integer, Integer> hs;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		hs = new HashMap<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if(hs.get(arr[i])==null) {
				hs.put(arr[i], 1);
				System.out.print(arr[i]+" ");
			}
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2217 {
	static int n;
	static int[] arr;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);
        for(int i=0 ; i<n ; i++){
            ans.add(arr[i]*(n-i));
        }
        System.out.println(Collections.max(ans));
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2548 {
	static int n;
	static int max=-1;
	static int[] arr;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]>max) max = arr[i];
		}
		for (int i = 1; i <= max; i++) {
			int temp=0;
			for (int j = 0; j < n; j++) {
				temp+=Math.abs(arr[j]-i);
			}
			list.add(temp);
		}
		int ansIndex = Collections.min(list);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)==ansIndex) {
				System.out.println(i+1);
				break;
			}
		}
	}
}

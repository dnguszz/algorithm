import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1517 {
	static int n;
	static long[] arr, temp;
	static long ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new long[n];
		temp = new long[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		merge(0,n-1);
		System.out.println(ans);
	}

	public static void merge(int left, int right) {
		if (left != right) {
			int mid = (left + right) / 2;
			merge(left, mid);
			merge(mid + 1, right);
			Sort(left, right);
		}
	}

	public static void Sort(int left, int right) {
		int mid = (left + right) / 2;
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (arr[i] > arr[j]) { 
				temp[k++] = arr[j++];
				ans += mid - i + 1;
			} else {
				temp[k++] = arr[i++];
			}
		}
		if (i > mid) {
			while (j <= right) {
				temp[k++] = arr[j++];
			}
		} 
		else {
			while (i <= mid) {
				temp[k++] = arr[i++];
			}
		}
		for (int h = left; h <= right; h++) {
			arr[h] = temp[h];
		}
	}
}

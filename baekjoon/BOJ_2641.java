import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2641 {
	static int n, m;
	static int[] arr, arr2;
	static ArrayList<int[]> ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		arr2 = new int[n];
		int[] arr2temp = new int[n];
		ans = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			switch (arr[i]) {
			case 2:
				arr2temp[i]=4;
				break;
			default:
				arr2temp[i]=(arr[i]+2)%4;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			arr2[i]=arr2temp[n-i-1];
		}
		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				temp[j]=Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]==arr[0]) {
					int[] newtemp = new int[n];
					for (int k = 0; k < n; k++) {
						newtemp[k]=temp[(j+k)%n];
					}
					if(isSame(newtemp, arr)) {
						ans.add(temp);
					}
				}
			}
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]==arr2[0]) {
					int[] newtemp = new int[n];
					for (int k = 0; k < n; k++) {
						newtemp[k]=temp[(j+k)%n];
					}
					if(isSame(newtemp, arr2)) {
						ans.add(temp);
					}
				}
			}
		}
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans.get(i)[j]+" ");
			}
			System.out.println();
		}
		
	}
	private static boolean isSame(int[] newtemp, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(newtemp[i]!=arr[i]) return false;
		}
		return true;
	}
}

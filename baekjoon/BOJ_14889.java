import java.io.*;
import java.util.*;

public class BOJ_14889 {
	static int n;
	static int[][] map;
	static int[] arr;
	static ArrayList<Integer> list;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		arr = new int[n/2];
		ans = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		nCr(0,0);
		System.out.println(Collections.min(ans));		
	}
	
	private static void nCr(int start,int cnt) {
		if(cnt==n/2) {
			list = new ArrayList<>();
			int[] arr2 = new int[n/2];
			for(int i=0 ; i<n ; i++) {
				list.add(i);
			}
			for(int i=0 ; i<n/2 ; i++) {
				list.remove((Integer) arr[i]);
			}
			for(int i=0 ; i<n/2 ; i++) {
				arr2[i]=list.get(i);
			}
			ans.add(Math.abs(syn(arr)-syn(arr2)));
			return;
		}
		for (int i = start; i < n; i++) {
			 arr[cnt]=i;
			 nCr(i+1, cnt+1);
		}
	}
	
	public static int syn(int[] arrT) {
		int ans=0;
		for(int i=0 ; i<arrT.length ; i++) {
			for (int j = 0; j < arrT.length; j++) {
				ans+=map[arrT[i]][arrT[j]];
			}
		}
		return ans;
	}
}
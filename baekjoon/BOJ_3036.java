package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3036 {
	static String s;
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[][] gy = new int[n][2];
		for(int i = 0 ; i< n ; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			gy[i][0]=arr[0];
			gy[i][1]=arr[i];
		}
		for(int i=1 ; i<n ; i++) {
			gy[i]=gyb(gy[i][0], gy[i][1]);
			System.out.println(gy[i][0]+"/"+gy[i][1]);
		}
	}
	public static int[] gyb(int a, int b) {
		int[] re = new int[2];
		int tempa=a;
		int tempb=b;
		for(int i=2 ; i<b+1 ; i++) {
			if(a%i==0 && b%i==0) {
				tempa=a/i;
				tempb=b/i;
			}
		}
		re[0]=tempa;
		re[1]=tempb;
		return re;
	}
}

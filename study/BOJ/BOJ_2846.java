package algo0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846 {
	static int n;
	static int[] arr;
	static int max=-999;
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=0;
		boolean flag=false;
		boolean flag2=false;
		for (int i = 1; i < n; i++) {
			if(arr[i]>arr[i-1]) {
				end=i;
				int or = arr[end]-arr[start];
				if(or>max) max=or;
				flag2=true;
			}
			else {
				int or = arr[end]-arr[start];
				if(or>max) max=or;
				start=i;
				flag=true;
			}
		}
		if(!flag) max = arr[arr.length-1]-arr[0];
		if(!flag2) max=0;
		System.out.println(max);
	}
}

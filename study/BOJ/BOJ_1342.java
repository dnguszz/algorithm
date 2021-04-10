package algo0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1342 {
	static char[] luck;
	static boolean[] vis;
	static int size;
	static String temp;
	static int ans=0;
	static int[] fac = new int[26];
	static int facInt=1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		temp = bf.readLine();
		for (int i = 0; i < temp.length(); i++) {
			fac[temp.charAt(i)-'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if(fac[i]!=0) {
				int temp=1;
				for (int j = 1; j <= fac[i]; j++) {
					temp*=j;
				}
				facInt*=temp;
			}
		}
		size=temp.length();
		vis = new boolean[size];
		luck = new char[size];
		P(0);
		System.out.println(ans/facInt);
	}
	public static void P(int cnt) {
		if(cnt==size) {
			boolean flag=true;
			for (int i = 1; i < luck.length; i++) {
				if(luck[i]==luck[i-1]) {
					flag=false;
					break;
				}
			}
			if(flag) {
				ans++;
			}
			return;
		}
		for (int i = 0; i < size; i++) {
			if(vis[i]) continue;			
			vis[i]=true;
			luck[cnt]=temp.charAt(i);
			P(cnt+1);
			vis[i]=false;
		}
	}
}

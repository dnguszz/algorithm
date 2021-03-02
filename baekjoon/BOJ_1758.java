package algo0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		long ans=0;
		Integer[] people = new Integer[n];
		for(int i=0 ; i<n ; i++) {
			people[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(people, Collections.reverseOrder());
		for(int i=0 ; i<n ; i++) {
			int temp=0;
			if(people[i]-i>=0) {
				temp = people[i]-i;
			}
			ans+=temp;
		}
		System.out.println(ans);
	}
}

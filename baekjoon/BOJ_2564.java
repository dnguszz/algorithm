package algo0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2564 {
	static int ans, x, y, t;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(bf.readLine());
		ans=0;
		int[][] loc = new int[t+1][2];
		int[] spot = new int[t+1];
		for(int i=0 ; i<t+1 ; i++) {
			st = new StringTokenizer(bf.readLine());
			loc[i][0]=Integer.parseInt(st.nextToken());
			loc[i][1]=Integer.parseInt(st.nextToken());
			switch(loc[i][0]) {
			case 1:
				spot[i]=x+2*y+(x-loc[i][1]);
				break;
			case 2:
				spot[i]=y+loc[i][1];
				break;
			case 3:
				spot[i]=loc[i][1];
				break;
			case 4:
				spot[i]=x+y+(y-loc[i][1]);
				break;
			}
		}
		for(int i=0 ; i<t ; i++) {
			ans+=cal(new int[] {spot[spot.length-1], spot[i]});
		}
		System.out.println(ans);		
	}
	public static int cal(int[] a) {
		Arrays.sort(a);
			if(Math.abs(a[1]-a[0])>Math.abs(((2*(x+y))-(a[1]-a[0])))) {
				return Math.abs(((2*(x+y))-(a[1]-a[0])));
			}
			else {
				return Math.abs(a[0]-a[1]);
			}
		}
}

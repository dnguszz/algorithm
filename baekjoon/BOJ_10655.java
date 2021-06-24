import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10655 {
	static int n;
	static int[][] point;
	static int dist;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		point = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			point[i][0]=Integer.parseInt(st.nextToken());
			point[i][1]=Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < n; i++) {
			dist+=Math.abs(point[i][0]-point[i-1][0])+Math.abs(point[i][1]-point[i-1][1]);
		}
		for (int i = 1; i < n-1; i++) {
			int before = (Math.abs(point[i][0] - point[i-1][0])+Math.abs(point[i][1] - point[i-1][1])) + 
					(Math.abs(point[i+1][0] - point[i][0])+Math.abs(point[i+1][1] - point[i][1]));
			int after = (Math.abs(point[i+1][0] - point[i-1][0])+Math.abs(point[i+1][1] - point[i-1][1]));
			int temp = before - after;
			if(dist-temp <ans) ans = dist-temp;
		}
		System.out.println(ans);
	}
}

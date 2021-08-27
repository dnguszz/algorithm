import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
	static int n, m;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] += Math.max(map[i][j-1],Math.max(map[i-1][j], map[i-1][j-1]));
            }
        }
		System.out.println(map[n][m]);
	}
}

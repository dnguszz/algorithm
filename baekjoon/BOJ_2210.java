import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2210 {
	static int[][] map;
	static HashMap<String, Boolean> hs;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		hs = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DFS(i,j, 0, Integer.toString(map[i][j]));
			}
		}
		System.out.println(ans);
	}
	
	public static void DFS(int x, int y, int cnt, String s) {
		if(cnt==5) {
			if(hs.get(s)==null) {
				hs.put(s, true);
				ans++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<5 && ny>=0 && ny<5) {
				DFS(nx,ny,cnt+1, s+Integer.toString(map[nx][ny]));
			}
		}
	}
}

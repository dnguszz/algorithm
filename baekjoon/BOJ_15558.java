import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558 {
	//BFS
	static int n, k;
	static int[][] map; //맵
	static boolean[][] vis;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[2][n];
		vis = new boolean[2][n];
		String str = bf.readLine();
		for (int i = 0; i < n; i++) {
			map[0][i]=str.charAt(i)-'0';
		}
		str = bf.readLine();
		for (int i = 0; i < n; i++) {
			map[1][i]=str.charAt(i)-'0';
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,0}); //왼쪽, 0번째칸, 경과시간(편의상 다 0부터)
		vis[0][0]=true;
		boolean flag = false; // 이 게임을 끝낼수 있으면 t, 아니면 f
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int cnt = temp[2];
			//case1 : +1만큼 이동
			if(y+1>=n) {
				flag=true;
				break;
			}
			else {
				if(!vis[x][y+1] && map[x][y+1]==1) {
					q.offer(new int[] {x,y+1,cnt+1});
					vis[x][y+1]=true;
				}
			}
			
			//case2 : -1만큼 이동
			if(y-1>=0 && !vis[x][y-1] && y-1>cnt && map[x][y-1]==1) {
				q.offer(new int[] {x,y-1,cnt+1});
				vis[x][y-1]=true;
			}
			
			//case3 : 반대칸 +k만큼 이동
			if(y+k>=n) {
				flag=true;
				break;
			}
			else {
				if(!vis[x^1][y+k] && y+k>cnt && map[x^1][y+k]==1) {
					q.offer(new int[] {x^1,y+k,cnt+1});
					vis[x^1][y+k]=true;
				}
			}
		}
		System.out.println(flag ? 1 : 0);
	}
}

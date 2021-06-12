package daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
	/*
	 * 아이디어 1. 종이에서 4칸을 선택한다음 선택한칸에서 4방향으로 bfs돌림, 만약 4칸이 모두 인접해있다면 크기가 4니까 bfs돌렸을때 크기 4면 계산해서 최대값 갱신
	 * N,M은 500까지니까 25000C4 = 1.6경 = 미친생각
	 * 아이디어 2. 테트로미노가 가질수있는 모양은 일자=2가지, 정사각형 = 1가지, ㄱ =  8가지, ㄱㄴ = 4가지, ㅏ = 4가지 총 19가지임, 귀찮음
	 * 아이디어 3. DFS돌려서 크기가 4인경우가 테트로미노모양임 = 이거다
	 *  ㅓㅏㅜㅗ 이모양은 DFS로 안되서 추가적으로돌려줘야함(검색했어요이건)
	 */
	static int n, m;
	static int map[][];
	static boolean vis[][];
	static int ans;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		ans=0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				vis = new boolean[n][m];
				vis[i][j]=true;
				DFS(i,j,map[i][j],0);
				vis[i][j]=false;
				checkAUOWOO(i,j);
			}
		}
		System.out.println(ans);
		
	}
	
	public static void DFS(int x, int y, int sum, int count){
        if(count>2) {
			if(ans<sum) ans=sum;
			return;
		}
        for(int i=0 ; i<4 ; i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if(tx>= 0 && tx<n && ty>=0 && ty<m) {
            	if(!vis[tx][ty]) {
            		vis[tx][ty]=true;
            		DFS(x+dx[i], y+dy[i], sum+map[tx][ty], count+1);
            		vis[tx][ty]=false;
            	}
            }
        }
    }
	
	public static void checkAUOWOO(int x, int y) {
		int sum = 0;
		if(x>=0 && x+1<n && y>=0 && y+2<m){
	        sum = map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1];
	        ans = Math.max(ans, sum);
	    }
	    if(x >= 0 && x+2 <n && y>=0 && y+1<m){
	        sum = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1];
	        ans = Math.max(ans, sum);
	    }

	    if(x-1 >= 0&& x <n && y >=0 && y+2 <m){
	        sum = map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1];
	        ans = Math.max(ans, sum);
	    }

	    if(x-1 >= 0 && x+1 <n && y >=0 && y+1 <m){
	        sum = map[x][y] + map[x][y+1] + map[x-1][y+1] + map[x+1][y+1];
	        ans = Math.max(ans, sum);
	    }
	}
}

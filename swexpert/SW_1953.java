package algo0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SW_1953 {
	/*
	 * bfs입니다.
	 * 초기조건의 맨홀부터 시작하여
	 * 한칸 이동할때마다 시간이 경과하는데
	 * 이동할수있는 조건은 
	 * 1. 현재칸에 있는 파이프의 방향으로만
	 * 2. 파이프의 방향을 따라갔을때 그 칸이 현재칸과 연결되어있어야함
	 * 3. 끝까지 도는게 아니라 정해진 카운트만큼만
	 * 파이프는 7개가 존재하는데 각 파이프는 4방향중에 선택된 방향으로 이동가능하므로 4방 배열을 만들고
	 * 다음칸의 조건또한 상, 하, 좌, 우 를 각각 포함하고있는 4개의 파이브가 선정됬습니다
	 */
    static int n, m, r, c, l;
    static int map[][];
    static boolean vis[][];
    static int ans;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1}; //상 하 좌 우
    static int[][] caseL = {{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}}; //순서대로 1~7까지 파이프의 방향
    static int[][] nextL = {{1,2,5,6}, {1,2,4,7}, {1,3,4,5}, {1,3,6,7}}; //상하좌우순으로 다음칸에 올수있는 파이프
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= test; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            ans=1;
            //bfs
            map = new int[n][m];
            vis = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
           //입력받고
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {r,c, 1});
            //맨홀뜨껑위치와 시간을 정수형 배열로 큐에 삽입
            vis[r][c]=true;
            while(!q.isEmpty()) { //bfs고고싱
                int[] temp = q.poll();  
                int tempCase = map[temp[0]][temp[1]];
                //시간이 경과할때마다 큐에서 빼내고
                if(tempCase==0) continue; //만약 파이프가없는 빈공간이면 패스
                for (int i = 0; i < caseL[tempCase-1].length; i++) {
                    int val = caseL[tempCase-1][i]; //큐에서 빼낸위치에서 갈수있는 방향만큼 돌림
                    if(ispos(temp[0]+dx[val], temp[1]+dy[val], temp[2]+1) && 
                    		!vis[temp[0]+dx[val]][temp[1]+dy[val]]) { //그 방향의 조건 검사 1. 맵의 범위에 있는지
                   	 												//2. 아직 방문 안했는지
                    												//3. 시간
                        int v = map[temp[0]+dx[val]][temp[1]+dy[val]];//갈수 있다면
                        if(v==nextL[val][0] || v==nextL[val][1] || v==nextL[val][2] || v==nextL[val][3]) {
                        	//갈수있는 방향에 있는 칸의 파이프를 조사, 만약 둘의 방향이 일치하면 큐에 삽입
                            q.offer(new int[] {temp[0]+dx[val], temp[1]+dy[val], temp[2]+1});
                            vis[temp[0]+dx[val]][temp[1]+dy[val]]=true; //방문처리
                            ans++; //숨을수있는곳 1 증가
                        }
                    }
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
     
    public static boolean ispos(int x, int y, int l2) { //조건검사 메소드
        if(x>=0 && x<n && y>=0 && y<m && l2<=l) return true;
        return false;
    }
}
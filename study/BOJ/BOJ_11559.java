import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11559 {
	static char[][] map;
	static boolean[][] vis;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int ans=0;
	static ArrayList<int[]> list;
	static boolean isDest;
	static int block;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String st = bf.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j]=st.charAt(j);
			}
		}//입력받고
		
		while(true) {
			isDest=false; //이번루프에서 연쇄가 일어났는지 확인용
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j]!='.') { //점이 아닐때
						block=0; //연결된 블럭수 0으로 초기화하고
						char temp = map[i][j]; //지금블럭의 뿌요
						vis = new boolean[12][6]; //방문배열
						list = new ArrayList<>(); //터져야할 좌표담음
						vis[i][j]=true;
						DFS(i,j, temp); //DFS돌려줌
						if(block>3) { //4번이상 호출되었다면 => 4개이상 붙어있다면
							isDest=true; //이번에 연쇄 일어났다 알리고
							for (int k = 0; k < list.size(); k++) {
								int x = list.get(k)[0];
								int y = list.get(k)[1];
								map[x][y]='.'; //그 좌표들 .으로 바꿈
							}
						}
					}
				}
			}
			//for문이 끝나면 => 연쇄가 일어난 모든 부분 .으로바뀜
			down(); //내려준다
			if(isDest) ans++; //연쇄가 일어났다면 결과 1 증가
			else break; //안일어났으면 루프 탈출
		}
		System.out.println(ans);
		
	}
	
	public static void DFS(int x, int y, char temp){
		block++; //DFS가 호출될때마다 block증가 => 연결되있는블럭수를 나탄낸다
		list.add(new int[] {x,y});//부수는 아니든 좌표 리스트에 담아주고
        for(int i=0 ; i<4 ; i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if(tx>= 0 && tx<12 && ty>=0 && ty<6) {
            	if(!vis[tx][ty] && map[tx][ty]==temp) {
            		vis[tx][ty]=true;
            		DFS(x+dx[i], y+dy[i], temp);//검사해서 재귀로 호출한다
            	}
            }
        }
    }
	public static void down() {
		for (int i = 0; i < 6; i++) {
			ArrayList<Character> lis = new ArrayList<>();
			for (int j = 11; j >= 0; j--) { //열 아래부터 올라가면서
				if(map[j][i]!='.') { //.이 아니면
					lis.add(map[j][i]); //리스트에 담고
				}
			}
			for (int j = 11; j >= 0; j--) { //열 전체 .으로 채우고
				map[j][i]='.';
			}
			int cnt=11;
			for (int j = 0; j<lis.size(); j++) {
				map[cnt--][i]=lis.get(j); //리스트에서 하나씩 꺼내면서 map 채워줌(아래부터)
			}
		}
	}
}

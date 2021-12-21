import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
	static int n, m;
	static HashMap<Integer, Integer> ladder;
	static HashMap<Integer, Integer> snake;
	static boolean[] vis;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vis = new boolean[101];
		ladder = new HashMap<>();
		//HashMap<u, v> => u에서 v로가는 사다리
		snake = new HashMap<>();
		//HashMap<x, y> => x에서 y로가는 뱀 
	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//입력 완
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1,0}); //(현재 위치, 주사위 굴린 횟수)
		vis[1]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int now = temp[0];
			int cnt = temp[1];
			if(now==100) { //기저조건 : 100에 오면 주사위 굴린 횟수 출력하고 종료
				System.out.println(cnt);
				break;
				//BFS의 특성상 기저조건에 처음 도달했을때가 주사위횟수 가장 적은거임 => 그냥 종료 
			}
			
			//현재위치 기준으로 1~6 앞칸의 조건을 고려한다
			for (int i = 1; i <= 6; i++) {
				int next = now+i;
				
				//현재+i번째칸이 사다리일때
				if(ladder.containsKey(next)) {
					//다음칸과 주사위굴린횟수+1을 넣어준다
					q.offer(new int[] {ladder.get(next), cnt+1});
				}
				
				//현재+i번째칸이 뱀일때
				else if(snake.containsKey(next)) {
					q.offer(new int[] {snake.get(next), cnt+1});
				}
				//사다리, 뱀일때 방문처리해주면 22%에서 틀리는데 왜인지 모르겠음
				
				//사다리 뱀 둘다 없는 일반칸일때
				else {
					//(현재칸+i번째칸이 범위 안에 있고 && 방문하지 않았을때) 
					if(next>=1 && next<=100 && !vis[next]) {
						vis[next]=true; //방문처리
						q.offer(new int[] {next, cnt+1});
					}
				}
			}
		}
	}
}

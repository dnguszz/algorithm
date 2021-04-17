import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
		boolean[][] map = new boolean[n+1][n+1]; //그래프연결관계나타내는 2차원배열
		boolean[] vis = new boolean[n+1]; //방문했는지나타내는배열
		Integer[] dist = new Integer[n+1]; //거리배열
		dist[0]=0; //0은사용안하고
		dist[1]=0; //1은 시작위치
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]]=true;
			map[edge[i][1]][edge[i][0]]=true;
		} //맵 채워주고
		
		Queue<int[]> q = new LinkedList<>(); //BFS
		q.offer(new int[] {1,0}); //큐에 초기위치랑 시간을 넣어준다
		vis[1]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 1; i <= n; i++) {
				if(map[temp[0]][i] && !vis[i]) { //뽑은위치에서 연결되어있고 아직 안갔다면
					q.offer(new int[] {i, temp[1]+1}); //다음위치랑 시간(거친 경로 수)넣어줌
					dist[i]=temp[1]+1; //경로수 dist배열에 넣어주고
					vis[i]=true; //방문처리
				}
			}
		}
		Arrays.sort(dist, Collections.reverseOrder()); //dist를 내림차순으로 정렬
		int max = dist[0]; //최대값뽑고
		int ans=0; //결과값
		for (int i = 0; i < dist.length; i++) {
			if(dist[i]==max) ans++; //최대값이 몇개있는지 
			else break;
		}
		return ans;
	}
}

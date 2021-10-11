import java.util.ArrayList;
import java.util.Arrays;

class edge {
	int dist;
	int weight;

	edge(int dist, int weight) {
		super();
		this.dist = dist;
		this.weight = weight;
	}
}

class Solution {
    static int[][] dist;
	static boolean[] vis;

	static ArrayList<edge>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer=Integer.MAX_VALUE;
		dist = new int[3][n+1];
		// 출발지에서 두 도착지까지 다익스트라로 구한다음 겹치는 부분 찾아서 그만큼 빼주면 된다? => 항상 성립 X
		adj = new ArrayList[n + 1]; // 1부터 n까지

		for (int i = 1; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < fares.length; i++) {
			int start = fares[i][0];
			int end = fares[i][1];
			int w = fares[i][2];
			adj[start].add(new edge(end, w));
			adj[end].add(new edge(start, w)); // 양방향
		} //정점입력
		
		dist[0]=dijk(s, n); //출발지에서
		dist[1]=dijk(a, n); //a에서
		dist[2]=dijk(b, n); //b에서
		
		for (int i = 1; i < n+1; i++) {
			if(dist[0][i] != Integer.MAX_VALUE && dist[1][i] != Integer.MAX_VALUE && dist[2][i] != Integer.MAX_VALUE) {
				int ans = dist[0][i] + dist[1][i] + dist[2][i];
				if (ans<answer) answer = ans;
			}
		}
        return answer;
    }
    
    public static int[] dijk(int start, int n) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		vis = new boolean[n + 1];
		dist[start] = 0; // 시작정점

		for (int i = 1; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;
			int w = -1;
			for (int j = 1; j < n + 1; j++) {
				if (!vis[j] && dist[j] < min) { // 방문 안했고 갈수 있음
					min = dist[j];
					w = j;
				}
			}
			if (w == -1)
				break;
			vis[w] = true;
			for (edge next : adj[w]) {
				int v = next.dist;
				if (!vis[v] && dist[v] > dist[w] + next.weight) {
					dist[v] = dist[w] + next.weight;
				}
			}
		}
		return dist;
	}
}

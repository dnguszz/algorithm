package algo0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591 {
	static int n, q;
	static ArrayList<ArrayList<int[]>> list;
	static boolean[] vis;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()); //출발점
			int b = Integer.parseInt(st.nextToken()); //도착점
			int c = Integer.parseInt(st.nextToken()); //유사도
			list.get(a).add(new int[] {b, c}); //a에서 b로가는 유사도 c의 경로 존재
			list.get(b).add(new int[] {a, c}); //b에서 a로가는 유사도 c의 경로 존재	
		}
		for (int i = 0; i < q; i++) {
			int cnt=0; //몇개추천되는지 담는 변수
			vis = new boolean[n+1];
			st = new StringTokenizer(bf.readLine());
			int s, u;
			u = Integer.parseInt(st.nextToken()); //유사도
			s = Integer.parseInt(st.nextToken()); //출발점
			//BFS시작
			Queue<Integer> q = new LinkedList<>();
			q.offer(s);
			vis[s]=true;
			while(!q.isEmpty()) {
				int temp = q.poll();
				for (int j = 0; j < list.get(temp).size(); j++) {
					int a = list.get(temp).get(j)[0]; //갈수있는 지점
					int b = list.get(temp).get(j)[1]; //유사도
					if(b>=u && !vis[a]) { //일반적인 BFS지만 유사도보다 작거나 같은경우만 큐에 담는다
						q.offer(a);
						vis[a]=true;
						cnt++; //추천영상 1 증가
					}
				}
			}
			System.out.println(cnt);
		}
	}
}

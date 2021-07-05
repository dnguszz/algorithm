package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922 {
	static int n, m, ans;
	static ArrayList<node> list;
	static int[] parent;
	//크루스칼로 최소신장트리 구하는문제라고 바로 떠올랐으나
	// 다까먹음
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		ans = 0;
		list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			list.add(new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list); //컴페레이터 만들었으니까 정렬이 가능
		parent = new int[n+1]; //유니온파인드에서 부모 자기자신으로
		for (int i = 1; i <= n; i++) {
			parent[i]=i;
		}
		
		for (int i = 0; i < list.size(); i++) {
			node temp = list.get(i); //가중치 오름차순 정렬된거에서 꺼내고
			int start = find(temp.st); // 시작점의 부모노드
			int end = find(temp.end); // 끝점의 부모노드 찾아
			if(start==end) continue; // 둘이 같다 = 연결되어있다 = 넘어감
			union(start,end); // 유니온파인드 해주고
			ans+=temp.val; // 가중치 결과값에 더해준다
		}
		System.out.println(ans);
	}

	public static int find(int a) {
		if (a == parent[a]) return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = b;
		} else {
			return;
		}
	}
}

class node implements Comparable<node> {
	int st;
	int end;
	int val;

	public node(int st, int end, int val) {
		super();
		this.st = st;
		this.end = end;
		this.val = val;
	}

	@Override
	public int compareTo(node N) {
		// TODO Auto-generated method stub
		return N.val >= this.val ? -1 : 1;
	}
}

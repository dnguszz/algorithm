import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 선공, 후공은 중요하지 않다.
// 1.한 턴 진행될때마다 각 점에서 탐색 돌릴건데 다시 나한테 오는지 => 시작점에서 DFS돌리고 탐색과정에서 시작점을 들린다 ? => 사이클 존재
// 	=>시간초과
// 2. a에서 b로 갈수있고 b에서 a로 갈수 있으면 사이클 존재한다고 생각. 단 둘중 하나라도 길이가 2이상이여야한다
// 어케구현하지
// 정수 이차원배열만들어서 arr[a][b]의 값에 거리를 저장하는방법? => n이 50만이네
// 해쉬사용하자 => 안될거같음
// 3. 아 유니온파인드
// 턴마다 입력값 2개의 부모 찾고 만약 같다면 사이클이 존재한다고 본다.
// 
public class BOJ_20040 {
	static int n, m;
	static int[] parent;//parent[i]는 i노드의 부모노드
	static int[] rank; //ver2
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i]=i;
			rank[i]=1;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			if(find(to)==find(from)) { 
				/*
				 입력받은값 2개의 부모가 같은지 비교
				 만약 같다면? 사이클 존재하는거임
				 why? 
				 만약 0과 3의 부모가 같다면 이 둘간의 경로가 존재하는데
				 이번 턴에 의해  1의 비용인 경로가 추가되니까
				 */
				System.out.println(i+1);
				System.exit(0);
			}
			//만약 사이클 없다면 둘끼리 연결해준다
			union(to,from);
		}
		System.out.println(0);
	}
	
	public static void union(int a, int b) { //부분집합끼리 묶는 메소드
		a = find(a);
		b = find(b);
		if(a==b) { //부모가 다르면(다른노드임)
			return;
		}
		//ver2
		if (rank[a] > rank[b]){
		    parent[b] = a;
		    rank[a] += rank[b];
		  }
		  else {
		    parent[a] = b;
		    rank[b] += rank[a];
		  }
		
	}
	public static int find(int i) { //부모 찾는 메소드
		if(parent[i]==i) { //본인이 부모(루트)노드임
			return i;
		}
		else {
			return find(parent[i]);
		}
	}
}

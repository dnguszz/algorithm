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
	//ũ�罺Į�� �ּҽ���Ʈ�� ���ϴ¹������ �ٷ� ���ö�����
	// �ٱ����
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
		Collections.sort(list); //���䷹���� ��������ϱ� ������ ����
		parent = new int[n+1]; //���Ͽ����ε忡�� �θ� �ڱ��ڽ�����
		for (int i = 1; i <= n; i++) {
			parent[i]=i;
		}
		
		for (int i = 0; i < list.size(); i++) {
			node temp = list.get(i); //����ġ �������� ���ĵȰſ��� ������
			int start = find(temp.st); // �������� �θ���
			int end = find(temp.end); // ������ �θ��� ã��
			if(start==end) continue; // ���� ���� = ����Ǿ��ִ� = �Ѿ
			union(start,end); // ���Ͽ����ε� ���ְ�
			ans+=temp.val; // ����ġ ������� �����ش�
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

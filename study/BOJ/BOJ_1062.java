import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1062 {
	static int n, k;
	static int max=0;
	static int[] arr;
	static boolean vis[];
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		if(k<5) {
			System.out.println(0);
			System.exit(0);
		}
		arr = new int[k-5];
		vis = new boolean[26];
		vis['a'-97]=true;
		vis['n'-97]=true;
		vis['t'-97]=true;
		vis['i'-97]=true;
		vis['c'-97]=true;
		for (int i = 0; i < n; i++) {
			String temp = bf.readLine();
			temp=temp.substring(4,temp.length());
			temp=temp.substring(0,temp.length()-4);
			list.add(temp);
		}
		if(k>=26) {
			System.out.println(n);
			System.exit(0);
		}
		C(0,0);
		System.out.println(max);
	}
	
	public static void C(int start, int cnt) {
		if(cnt==k-5) {
			int[] Narr = new int[k];
			Narr[0]=0;
			Narr[1]=2;
			Narr[2]=8;
			Narr[3]=13;
			Narr[4]=19;
			for (int i = 5; i < Narr.length; i++) {
				Narr[i]=arr[i-5];
			}
			int count=0;
			boolean flag;
			boolean flag2;
			for (int i = 0; i < list.size(); i++) {
				flag2=true;
				for (int j = 0; j < list.get(i).length(); j++) {
					flag=false;
					for (int j2 = 0; j2 < k; j2++) {
						if(list.get(i).charAt(j)==(char) ('a'+Narr[j2])) {
							flag=true;
						}
					}
					if(!flag) {
						flag2=false;
						break;
					}
				}
				if(flag2) count++;
			}
			if(count>max) {
				max=count;	
			}
			return;
		}
		for (int i = start; i < 26; i++) {
			if(!vis[i]) {
				arr[cnt]=i;
				C(i+1, cnt+1);
			}
		}
	}
}

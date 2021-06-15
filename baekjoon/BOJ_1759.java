import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int l, c;
	static char[] arr;
	static int[] arr2;
	static boolean[] vis;
	static HashMap<Integer, Character> hs;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		arr = new char[c];
		hs = new HashMap<>();
		for (int i = 0; i < c; i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		for (int i = 0; i < c; i++) {
			hs.put(i, arr[i]);
		}
		arr2 = new int[l];
		vis = new boolean[c];
		C(0,0);
	}
	
	private static void C(int start,int cnt) {
		if(cnt==l) {
			boolean flag=false;
			boolean flag2=false;
			for (int i = 0; i < l; i++) {
				if(hs.get(arr2[i])=='a' || hs.get(arr2[i])=='e' || hs.get(arr2[i])=='i' || hs.get(arr2[i])=='o' || hs.get(arr2[i])=='u') {
					flag=true;
					break;
				}
			}
			int flag3=0;
			for (int i = 0; i < l; i++) {
				if(hs.get(arr2[i])!='a' && hs.get(arr2[i])!='e' && hs.get(arr2[i])!='i' && hs.get(arr2[i])!='o' && hs.get(arr2[i])!='u') {
					flag3++;
				}
				if(flag3>1) {
					flag2=true;
					break;
				}
			}
			if(!flag || !flag2) return;
			for (int i = 0; i < l; i++) {
				System.out.print(hs.get(arr2[i]));
			}
			System.out.println();
			return;
		}
		for (int i = start; i < c; i++) {
			 arr2[cnt]=i;
			 C(i+1, cnt+1);
		}
	}
}

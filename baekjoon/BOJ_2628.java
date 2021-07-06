import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2628 {
	static int x, y, n, tempx, tempy, max;
	static boolean[][] map;
	static ArrayList<Integer> listx, listy, chax, chay;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(bf.readLine());
		max = -1;
		listx = new ArrayList<>();
		listx.add(0);
		listx.add(x);
		listy = new ArrayList<>();
		listy.add(0);
		listy.add(y);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int type = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if(type==0) {
				listy.add(val);
			}
			else listx.add(val);
		}
		Collections.sort(listx);
		Collections.sort(listy);
		chax = new ArrayList<>();
		chay = new ArrayList<>();
		for (int i = 0; i < listx.size()-1; i++) {
			chax.add(listx.get(i+1)-listx.get(i));
		}
		for (int i = 0; i < listy.size()-1; i++) {
			chay.add(listy.get(i+1)-listy.get(i));
		}
		for (int i = 0; i < chax.size(); i++) {
			for (int j = 0; j < chay.size(); j++) {
				int temp = chax.get(i)*chay.get(j);
				if(temp>max) max = temp;
			}
		}
		System.out.println(max);
	}
}

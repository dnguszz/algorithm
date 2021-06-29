import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2659 {
	static int s1, s2, s3, s4;
	static int[] n;
	static int min = 999999;
	static ArrayList<Integer> list;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = new int[4];
		ans = 0;
		list = new ArrayList<>();
		s1 = Integer.parseInt(st.nextToken());
		s2 = Integer.parseInt(st.nextToken());
		s3 = Integer.parseInt(st.nextToken());
		s4 = Integer.parseInt(st.nextToken());
		n[0] = s1*1000+s2*100+s3*10+s4;
		n[1] = s2*1000+s3*100+s4*10+s1;
		n[2] = s3*1000+s4*100+s1*10+s2;
		n[3] = s4*1000+s1*100+s2*10+s3;
		for (int i = 0; i < 4; i++) {
			if(min>n[i]) min = n[i];
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					for (int h = 1; h < 10; h++) {
						int[] temp = new int[4];
						int tempMin=99999;
						temp[0] = i*1000+j*100+k*10+h;
						temp[1] = j*1000+k*100+h*10+i;
						temp[2] = k*1000+h*100+i*10+j;
						temp[3] = h*1000+i*100+j*10+k;
						for (int l = 0; l < 4; l++) {
							if(temp[l]<tempMin) tempMin = temp[l];
						}
						if(!list.contains(tempMin)) list.add(tempMin);
					}
				}
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)==min) {
				System.out.println(i+1);
				System.exit(0);
			}
		}
	}
}

package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_5904 {
	static int N, mootemp, n;
	static ArrayList<Integer> len;
	static int dk=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		len = new ArrayList<>();
		len.add(3); //s(0)일때 길이
		n=1;
		mootemp=3; //가운데 moo..의길이
		while(true) {
			mootemp++;
			len.add(2*len.get(n-1)+3+n);
			if(len.get(n)>=N) break;
			n++;
		}
		moo(N);
		//가운데 moo의 길이는 4,5,6,7...
	}
	public static void moo(int index) { //n이 문자열의 왼쪽,중간,오른쪽에있는지 구해서 각 경우마다 재귀호출

		if(index==1) {
			System.out.println(index+"좌");
			System.out.println('m');
		}
		else if(index==2 || index==3) {
			System.out.println(index+"좌");
			System.out.println('o');
		}
		else {
			if(index<=len.get(n-1)) {
				n--;
				mootemp--;
				moo(index);
			}
			else if(index>len.get(n-1) && index<=len.get(n-1)+mootemp) {
				System.out.println(index+"중");
				int tempp = index- len.get(n-1);
				if(tempp==1) {
					System.out.println('m');
				}
				else System.out.println('o');
			}
			else {
				System.out.println(index+"우");
				moo(index-(len.get((n--)-1)+mootemp--));
			}
		}
	}
}

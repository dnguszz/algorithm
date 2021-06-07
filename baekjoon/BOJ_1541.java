import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
	static String[] n;
	static int[] num;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] n = bf.readLine().split("-");
		
		num = new int[n.length];
		
		for(int i = 0 ; i<n.length ; i++) {
			String[] temp = n[i].split("\\+"); //+못써서 \\+써야함
			int count=0;
			int[] tempn = new int[temp.length];
			for(int j = 0 ; j<temp.length ; j++) {
				tempn[j]=Integer.parseInt(temp[j]);
				count+=tempn[j];
			}
			num[i]=count;
		}
		ans=num[0];
		for(int i = 1 ; i<num.length ; i++) {
			ans-=num[i];
		}
		System.out.println(ans);
	}
}

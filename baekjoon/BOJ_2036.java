import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static long n;
	static ArrayList<Long> plus, minus;
	static boolean zero=false;
	static long ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(bf.readLine());
		plus = new ArrayList<>();
		minus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long temp = Long.parseLong(bf.readLine());
			if(temp>0) {
				if(temp ==1) ans+=1;
				else plus.add(temp);
			}
			else if (temp<0) minus.add(temp);
			else if(temp==0) zero=true;
		}
		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		if(minus.size()>0) {
			if(minus.size()%2==0) { //음수 짝수개일때
				for (int i = 0; i < minus.size()-1; i+=2) {
					ans+= minus.get(i)*minus.get(i+1);
				}
			}
			else {
				for (int i = 0; i < minus.size()-2; i+=2) {
					ans+= minus.get(i)*minus.get(i+1);
				}
				if(!zero) ans+=minus.get(minus.size()-1);
			}
		}
		if(plus.size()>0) {
			if(plus.size()%2==1) { //양수 홀수개
				for (int i = 0; i < plus.size()-2; i+=2) {
					ans+= plus.get(i)*plus.get(i+1);
				}
				ans+=plus.get(plus.size()-1);
			}
			else { //양수 짝수개
				if(plus.get(plus.size()-1)==1) {
					for (int i = 0; i < plus.size()-3; i+=2) {
						ans+= plus.get(i)*plus.get(i+1);
					}
					ans+=plus.get(plus.size()-1);
					ans+=plus.get(plus.size()-2);
				}
				else {
					for (int i = 0; i < plus.size()-1; i+=2) {
						ans+= plus.get(i)*plus.get(i+1);
					}
				}
			}
		}
		System.out.println(ans);
	}
}

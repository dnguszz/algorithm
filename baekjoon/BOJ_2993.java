import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2993 {
	static char[] arr;
	static ArrayList<String> ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String temp = bf.readLine();
		
		//0부터 i
		//i+1부터 j-1
		//j부터  사이즈-1
		ans = new ArrayList<>();
		for (int i = 1; i < temp.length()-2; i++) {
			for (int j = i+1; j < temp.length()-1; j++) {
				StringBuffer tempB = new StringBuffer();
				StringBuffer sb1 = new StringBuffer(temp.substring(0,i));
				StringBuffer sb2 = new StringBuffer(temp.substring(i,j+1));
				StringBuffer sb3 = new StringBuffer(temp.substring(j+1,temp.length()));
				tempB.append(sb1.reverse().toString());
				tempB.append(sb2.reverse().toString());
				tempB.append(sb3.reverse().toString());
				ans.add(tempB.toString());
			}
		}
		Collections.sort(ans);
		System.out.println(ans.get(0));
	}
}

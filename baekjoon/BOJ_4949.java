import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = bf.readLine();
			if(s.equals(".")) break;
			ArrayList<Character> list = new ArrayList();
			for(int i =0 ; i<s.length(); i++) {
				if(s.charAt(i)=='(' || s.charAt(i)==')' || s.charAt(i)=='[' || s.charAt(i)==']') {
					list.add(s.charAt(i));
				}
			}
			System.out.println(tf(list) ? "yes" : "no");
		}
	}
	
	public static boolean tf(ArrayList<Character> list) {
		ArrayList<Character> list2 = new ArrayList();
		for(int i=0 ; i< list.size(); i++) {
			if((char)list.get(i)=='(') {
				list2.add((char)list.get(i));
			}
			
			else if((char)list.get(i)=='[') {
				list2.add((char)list.get(i));
			}
			else if((char)list.get(i)==')') {
				if(list2.size()==0) {
					return false;
				}
				else if ((char)list2.get(list2.size()-1)=='(') {
					list2.remove(list2.size()-1);
				}
				else return false;
			}
			else if((char)list.get(i)==']') {
				if(list2.size()==0) {
					return false;
				}
				else if ((char)list2.get(list2.size()-1)=='[') {
					list2.remove(list2.size()-1);
				}
				else return false;
			}
		}
		
		if(list2.size()==0) {
			return true;
		}
		else return false;
	}
}
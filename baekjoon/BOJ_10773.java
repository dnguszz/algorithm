import java.io.*;
import java.util.*;

public class BOJ_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String ns = bf.readLine();
		int n=Integer.parseInt(ns);
		List list = new ArrayList();
		int count=0;
		for(int i=0 ; i<n ; i++) {
			String temp = bf.readLine();
			int num = Integer.parseInt(temp);
			if(num==0) {
				list.remove(list.size()-1);
			}
			else {
				list.add(num);
			}
		}
		for(int i=0 ; i<list.size(); i++) {
			count+=(int) list.get(i);
		}
		System.out.println(count);
	}
}

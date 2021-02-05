package alog0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_5587 {
	static int pos;
	static ArrayList<Integer> brd;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> sg = new ArrayList<>();
		ArrayList<Integer> gs = new ArrayList<>();
		brd = new ArrayList<>();
		int turn = 0;
		int t = Integer.parseInt(bf.readLine());
		for(int i=1 ; i<=t ; i++) {
			sg.add(Integer.parseInt(bf.readLine()));
		}
		for(int i=1 ; i<=2*t ; i++) {
			if(!sg.contains(i)) gs.add(i);
		}
		Collections.sort(sg);
		int cnt=1;
		while(true) {
			if(sg.isEmpty() || gs.isEmpty()) break;
			if(brd.isEmpty()) {
				if(turn==0) {
					brd.add(Collections.min(sg));
					sg.remove((Integer)Collections.min(sg));
					turn=1;
				}
				else {
					brd.add(Collections.min(gs));
					gs.remove((Integer)Collections.min(gs));
					turn=0;
				}
			}
			else {
				if(turn==0) {
					if(findC(sg, brd.get(brd.size()-1))) {
						brd.add(sg.get(pos));
						sg.remove(pos);
						turn=1;
					}
					else {
						brd = new ArrayList();
						turn=1;
					}
				}
				else { //turn==1
					if(findC(gs, brd.get(brd.size()-1))) {
						brd.add(gs.get(pos));
						gs.remove(pos);
						turn=0;
					}
					else {
						brd = new ArrayList();
						turn=0;
					}
				}
			}
		}
		System.out.println(gs.size());
		System.out.println(sg.size());
	}
	
	public static boolean findC(ArrayList list, int last) {
		pos=0;
		for(int i=0 ; i<list.size() ; i++) {
			if((int) list.get(i)>last) {
				pos=i;
				return true;
			}
		}
		return false;
	}
}

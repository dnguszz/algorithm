import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2992 {
	static String x;
	static int[] arr;
	static boolean[] vis;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		x = bf.readLine();
		vis = new boolean[x.length()];
		arr = new int[x.length()];
		list = new ArrayList<>();
		P(0);
		System.out.println(list.size()!=0 ? Collections.min(list) : "0");
	}
	
	public static void P(int cnt){
        if(cnt==x.length()){
            StringBuffer sb = new StringBuffer();
            for(int j=0 ; j<x.length() ; j++){
            	sb.append(x.charAt(arr[j]));
            }
            if(Integer.parseInt(sb.toString())>Integer.parseInt(x)) {
            	list.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for(int i=0 ; i<x.length() ; i++){
            if(vis[i]){
                continue;
            }
            vis[i]=true;
            arr[cnt]=i;
            P(cnt+1);
            vis[i]=false;
        }
    }
}

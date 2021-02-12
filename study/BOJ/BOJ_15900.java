package algo0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15900 {
	static ArrayList<ArrayList<Integer>> list;
	static int ans;
	static boolean[] vis;
	static ArrayList<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ans=0;
        list = new ArrayList<>();
        res = new ArrayList<>();
        vis = new boolean[n+1];
        for(int i=0 ; i<n+1 ; i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=0 ; i<n-1 ; i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list.get(a).add(b);
        	list.get(b).add(a);
        }
        dfs(1, 0);
        if(ans%2==0) System.out.println("No");
        else System.out.println("Yes");
    }
    
    public static void dfs(int n, int cnt) {
    	vis[n]=true;
    	if(list.get(n).isEmpty()) {
    		return;
    	}
    	else if(list.get(n).size()==1) {
    		ans+=cnt;
    	}
    	for(int i=0 ; i<list.get(n).size() ; i++) {
    		if(!vis[list.get(n).get(i)]) {
    			dfs(list.get(n).get(i), cnt+1);
    		}
    	}
    }
}


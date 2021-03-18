import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16562 {
    static int n, m, k;
    static int[] money;
    static int[] parent;
    static int[] rank;
    static int ans;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());
        money = new int[n+1];
        parent = new int[n+1];
        rank = new int[n+1];
        ans=0;
        list = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
        for(int i=1 ; i<n+1 ; i++){
            money[i]=Integer.parseInt(st2.nextToken());
        }
        for(int i=0 ; i<n+1 ; i++){
            list.add(new ArrayList<>());
        }
        make();
        for(int i=0 ; i<m ; i++){
            StringTokenizer st3 = new StringTokenizer(bf.readLine(), " ");
            union(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken()));
        }
        for(int i=1 ; i<n+1 ; i++){
            int temp=findSet(i);
            list.get(temp).add(money[i]);
        }
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i).size()!=0){
                ans+= Collections.min(list.get(i));
            }
        }
        if(ans>k){
            System.out.println("Oh no");
        }
        else{
            System.out.println(ans);
        }
    }

    static void make() {
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    }

    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (rank[aRoot] < rank[bRoot]) {
            parent[aRoot] = bRoot;
        } else {
            parent[bRoot] = aRoot;
            if (rank[aRoot] == rank[bRoot]) {
                rank[aRoot]++;
            }
        }
    }
}

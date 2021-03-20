import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int n, m;
    static int parent[];
    static int rank[];
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        m=Integer.parseInt(bf.readLine());
        parent = new int[n];
        rank = new int[n];
        make();
        for(int i=0 ; i<n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for(int j=0 ; j<i+1 ; j++){
                if(st.nextToken().equals("1")){
                    union(i,j);
                }
            }
        }
        flag=true;
        StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
        int temp = findSet(Integer.parseInt(st2.nextToken())-1);
        for(int i=1 ; i<m ; i++){
            if(findSet(Integer.parseInt(st2.nextToken())-1)!=temp){
                flag=false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void make() {
        for (int i = 0; i < n ; i++) {
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

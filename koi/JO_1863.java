import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_1863 {
    static int n, m, ans;
    static int parent[];
    static int rank[];
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        ans = 0;
        parent = new int[n + 1];
        rank = new int[n + 1];
        list = new ArrayList<>();
        make();
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
            union(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
        }
        for (int i = 1; i < n + 1; i++) {
            int temp = findSet(i);
            if (!list.contains(temp)) {
                list.add(temp);
                ans++;
            }
        }
        System.out.println(ans);
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

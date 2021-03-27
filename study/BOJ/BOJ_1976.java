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
        make(); //0~n-1까지 생성
        for(int i=0 ; i<n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " "); //인접행렬 입력받는부분
            for(int j=0 ; j<i+1 ; j++){
                if(st.nextToken().equals("1")){ // 입력의 인접행렬의 i과 j가 연결되어있다면
                    union(i,j); //둘을 묶음
                }
            }
        }
        flag=true;
        StringTokenizer st2 = new StringTokenizer(bf.readLine(), " "); //여행경로 입력
        int temp = findSet(Integer.parseInt(st2.nextToken())-1);
        for(int i=1 ; i<m ; i++){ //여행경로를 처음부터 탐색하며 모든 경로가 묶여있으면
                                  //즉, 패런트가 모두 같으면 flag는 트루, 하나라도 다른게 나오면 false
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

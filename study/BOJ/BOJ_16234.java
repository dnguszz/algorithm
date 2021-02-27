import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int n, l, r;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<ArrayList<int[]>> land;
    static ArrayList<int[]> list;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        } //배열에 입력값 넣음
        boolean flag; //이동이 전부 완료됬는지 체크하는 변수
        while(true) {
            flag=false;
            land = new ArrayList<>();
            vis = new boolean[n][n]; //방문 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    list = new ArrayList<>();
                    if(!vis[i][j]) open(i, j); //0,0부터 bfs돌립니다
                    //bfs완료되면 이동가능한 나라들의 좌표들이 list배열에 담김
                    if (list.size() != 1) { //open호출시에 이동가능 나라가 없더라도 호출된 나라는 배열에 담기니까
                        land.add(list); //이동가능한 나라들은 한꺼번에 이동하므로 이를 land에 담음
                        flag=true; //이동이 발생하면 flag를 true로 = 이동이 안발생하면 flag는 flage = 조건을 만족함
                    }

                }
            }
            if (!land.isEmpty()) move(land); //이동할 국가들이 존재한다면 이동
            if(!flag) break; //이동이 안발생하면 flag는 flage = 조건을 만족함 = 루프 탈출
        }
        System.out.println(ans);
    }
    public static void open(int i, int j) {
        list.add(new int[]{i, j});
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (ispos(i + dx[k], j + dy[k]) && !vis[i + dx[k]][j + dy[k]] &&
                    Math.abs(map[i][j] - map[i + dx[k]][j + dy[k]]) <= r && Math.abs(map[i][j] - map[i + dx[k]][j + dy[k]]) >= l) {
                open(i + dx[k], j + dy[k]);
            }
        }
    }
    public static boolean ispos(int i, int j) { //i, j값이 배열의 범위인지
        if (i >= 0 && i < n && j >= 0 && j < n) return true;
        else return false;
    }
    public static void move(ArrayList<ArrayList<int[]>> arr) {
        for(int k=0 ; k<arr.size() ; k++){
            double sum = 0;
            for (int i = 0; i < land.get(k).size(); i++) {
                sum += map[land.get(k).get(i)[0]][land.get(k).get(i)[1]];
            }
            sum /= land.get(k).size();
            for (int i = 0; i < land.get(k).size(); i++) {
                map[land.get(k).get(i)[0]][land.get(k).get(i)[1]] = (int) sum;
            }
        }
        ans++; //이동이 발생하면 횟수증가
    }
}

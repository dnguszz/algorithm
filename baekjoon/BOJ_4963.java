import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static char[][] map;
    static boolean[][] vis;
    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int num = 0; //섬 개수 저장할변수
            w = Integer.parseInt(st1.nextToken());
            h = Integer.parseInt(st1.nextToken());
            map = new char[h][w];
            vis = new boolean[h][w];
            if (w == 0 && h == 0) {
                break;
            } //마지막입력때 루프 탈출 => 종료
            for (int k = 0; k < h; k++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for (int u = 0; u < w; u++) {
                    map[k][u] = st.nextToken().charAt(0);
                }
            }
            for (int k = 0; k < h; k++) {
                for (int u = 0; u < w; u++) {
                    if (map[k][u] == '1' && !vis[k][u]) {
                        num++;
                        dfs(k, u);
                    }
                }
            }
            System.out.println(num);
        }
    }

    public static void dfs(int i, int j) {
        vis[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if (i + dx[k] >= 0 && i + dx[k] < h && j + dy[k] >= 0 && j + dy[k] < w &&
                    !vis[i + dx[k]][j + dy[k]] && map[i + dx[k]][j + dy[k]] == '1') {
                vis[i + dx[k]][j + dy[k]] = true;
                dfs(i + dx[k], j + dy[k]);
            }
        }
    }
}
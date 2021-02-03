import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1004 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for(int t=0 ; t<testCase ; t++){
            int cnt=0;
            int[] start= new int[2];
            int[] dest= new int[2];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<2 ; j++){
                start[j]=Integer.parseInt(st.nextToken());
            }
            for(int j=0 ; j<2 ; j++){
                dest[j]=Integer.parseInt(st.nextToken());
            }
            int planet = Integer.parseInt(bf.readLine());
            int[][] p = new int[planet][3];
            for(int i=0 ; i<planet ; i++){
                StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
                for(int j=0 ; j<3 ; j++){
                    p[i][j]=Integer.parseInt(st2.nextToken());
                }
            }
            for(int i=0 ; i<planet ; i++){
                if(Math.pow(Math.pow(start[0]-p[i][0],2)+Math.pow(start[1]-p[i][1],2), 0.5)<p[i][2] &&
                        Math.pow(Math.pow(dest[0]-p[i][0],2)+Math.pow(dest[1]-p[i][1],2), 0.5)<p[i][2]){
                    cnt-=2;
                }
                if(Math.pow(Math.pow(start[0]-p[i][0],2)+Math.pow(start[1]-p[i][1],2), 0.5)<p[i][2]) cnt++;
                if(Math.pow(Math.pow(dest[0]-p[i][0],2)+Math.pow(dest[1]-p[i][1],2), 0.5)<p[i][2]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}

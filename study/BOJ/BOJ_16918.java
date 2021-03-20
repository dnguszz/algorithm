import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int r, c, n;
    static int map[][];
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int count=0;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        n= Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[r][c];
        for(int i=0 ; i<r ; i++){
            String str=bf.readLine();
            for(int j=0 ; j<c; j++){
                if(str.charAt(j)=='O'){
                    map[i][j]=1;
                }
            }
        }
        while(count<=n){
            if(count>1) {
                if (count % 2 == 0) { //폭설
                    timer2();
                    sul();
                }
                else{
                    timer();
                }
            }
            else{
                timer2();
            }
                count++;
        }
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) System.out.print('O');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
    public static void sul(){
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]==0) map[i][j]=1;
            }
        }
    }

    public static void timer(){
        list.clear();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) map[i][j]++;
                if(map[i][j]>=4){
                    list.add(new int[] {i,j});
                }
            }
        }
        for(int i=0 ; i<list.size() ; i++){
            int a=list.get(i)[0];
            int b=list.get(i)[1];
            map[a][b]=0;
            for(int k=0 ; k<4 ; k++){
                if(a+dx[k]>=0 && a+dx[k]<r && b +dy[k]>=0 && b+dy[k]<c) map[a+dx[k]][b+dy[k]]=0;
            }
        }
    }

    public static void timer2(){
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) map[i][j]++;
            }
        }
    }
}

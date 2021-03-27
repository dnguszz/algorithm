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
        //초기상태로 채움
        while(count<=n){ //n초까지 시뮬 돌림
            if(count>1) { //초기 2초 이후부터의 과정
                if (count % 2 == 0) { //폭설
                    timer2(); //폭탄의 카운트 증가
                    sul(); //비어있는칸에 폭탄 설치
                }
                else{
                    timer(); //폭탄 터짐(홀수일때만), 주변4방향까지 평지로 만듬
                }
            }
            else{ //초기 1초까지는 설치하고 아무것도 안함, 대신 폭탄 카운트는 증가(1,2의 과정)
                timer2();
            }
                count++;
        }
        //출력부
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) System.out.print('O');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
    public static void sul(){ //맵에서 0인 부분에 폭탄을 설치함(폭탄 설치시 초기 카운트를 1로)
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]==0) map[i][j]=1;
            }
        }
    }

    public static void timer(){ //터지는 부분
        list.clear();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) map[i][j]++;
                if(map[i][j]>=4){
                    list.add(new int[] {i,j}); //카운트가 4이상인 좌표 리스트에 넣고
                }
            }
        }
        for(int i=0 ; i<list.size() ; i++){ //리스트에서 빼면서 인접한 칸 파괴
            int a=list.get(i)[0];
            int b=list.get(i)[1];
            map[a][b]=0;
            for(int k=0 ; k<4 ; k++){
                if(a+dx[k]>=0 && a+dx[k]<r && b +dy[k]>=0 && b+dy[k]<c) map[a+dx[k]][b+dy[k]]=0;
            }
        }
    }
    //리스트를 사용한 이유는 만약 카운트 4이상인부분을 탐색과 동시에 터트리면 
    //그에 인접하고 카운트가 4이상인 부분의 인접한 칸이 안터짐(카운트가 0으로 인식)

    public static void timer2(){ //폭발없이 카운트만 증가(초가 짝수일때)
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(map[i][j]!=0) map[i][j]++;
            }
        }
    }
}

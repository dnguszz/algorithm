import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
    static int N, r, c;
    static long ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ans=0;
        N=Integer.parseInt(st.nextToken()); //2^N * 2^N 배열 생성
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken()); //r행,c열의 숫자를 구해보자
        z(N); //z메소드에서 재귀를 통해 값 ans변수에 저장
        System.out.println(ans);
    }

    public static void z(int n) {
        if(n==0) return; //기저
        else {
            int t = (int) Math.pow(2, n); //t는 변의길이

            //정사각형 배열을 4등분했을때 r,c가 어느영역에 위치하는지를 계산
            int x, y;
            if(r>=t/2) y=1;
            else y=0;
            if(c>=t/2) x=1;
            else x=0;
            //

            //r ,c의 위치가 파악되면 각 위치에 해당하는 값을 ans에 더함
            //ex) N이 3이면 정사각형은 8*8, 이는 4*4 정사각형 4개로 나뉘고 각 사각형의 시작점은 0, 16, 32, 48 = 2^(2*n-2)*t (t= 0,1,2,3)
            if(x==0 && y==0) {
                ans+=0*Math.pow(2, 2*n-2);
            }
            else if(x==0 && y==1) {
                ans+=2*Math.pow(2, 2*n-2);
                r-=t/2;
            }
            else if(x==1 && y==0) {
                ans+=1*Math.pow(2, 2*n-2);
                c-=t/2;
            }
            else { //1,1
                ans+=3*Math.pow(2, 2*n-2);
                r-=t/2;
                c-=t/2;
            }
            //각 사각형의 시작점에서 다시 함수 실행(기저함수만날때까지), 이과정에서 r,c의 값을 조정해줌
            z(n-1);
        }
    }
}

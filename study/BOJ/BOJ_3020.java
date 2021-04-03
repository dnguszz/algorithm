package algo2021_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020 {
    static int n, h;
    static int[] bot, top, res, topbroken;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        bot = new int[h];
        top = new int[h];
        //석순과 종유석을 담는 배열, i번째 장애물의 높이를 담는게 아닌 높이 i에서 부서지는 개수를 담음
        topbroken = new int[h];
        //종유석 임시저장용
        res = new int[h];
        //높이 i에서 부셔야할 장애물을 담는 배열
        for(int i=0 ; i<n/2 ; i++){
            bot[Integer.parseInt(bf.readLine())]++;
            top[Integer.parseInt(bf.readLine())]++;
        }
        for(int i=1 ; i<h ; i++){
            bot[i]+=bot[i-1];
            top[i]+=top[i-1];
        }
        //누적합을 구함, 높이가 i인 석순의 개수 -> 높이가 i 이하인 석순의 개수
        topbroken=top.clone();
        //종유석에서 사용하는 로직용 배열 복사
        for(int i=0 ; i<h ; i++){
            bot[i]=bot[h-1]-bot[i];
            //석순의 개수에서 높이i 이하인 개수를 빼줘 높이가 i일때 부서지는 석순의 개수를 구함
            top[i]=top[h-1]-topbroken[h-1-i];
            //종유석의 개수에서 뒤부터 시작하는 값을 빼줘 높이가 i일때 부서지는 종유석의 개수를 구함
        }
        for (int i=0 ; i<h ; i++){
            res[i]=bot[i]+top[i];
            //i일때 부서지는 전체 장애물의 수
        }
        Arrays.sort(res);
        int min = res[0];
        //최소값 찾고
        int ans=0;
        //res는 오름차순되어있는상태
        for(int i=0 ; i<h ; i++){
            if(res[i]==min) ans++;
            //최소값만나면 경우값 추가
            else break;
            //최소값 벗어나면 반복문 탈출
        }
        System.out.println(min+" "+ans);
    }
}

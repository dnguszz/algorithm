package algo2021_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
vip석 기준으로 선택할수있는 칸이 나뉘어짐
예제에서 4와 7이 vip이므로
움직일수있는칸은 123 / 56 / 89
각 칸에서 나올수있는 경우의수를 곱해주면된다.
이를 점화식으로 구하면
좌석수가 1일때 = 1
1 선택가능

2일때 = 1
12
21 가능

3일때 = 3
123
213
132

이를 자세히보면
2일때 선택가능한 경우의 끝에 3을 붙인경우(123, 213)
마지막숫자 이전의 수가 2일경우 3과 바꾼경우 (132)

여기까진 모르겠는데 4로넘어가면
1234
2134
1324
1243
2143

5가지경우임
이경우도 3으로 끝나는 경우에 4를 붙인 경우(1234, 2134, 1324) = arr[3]의 수
마지막숫자 이전의 수가 3일 경우 4와 바꾼경우 (1243, 2143) = arr[2]의 수

==
arr[2]까지는 숫자의 수만큼의 인덱스를 같고 그 이후에는
arr[i]=arr[i-1]+arr[i-2]의 점화식이 세워짐

점화식으로 arr배열을 구하고
앞서구한 영역의수를 탐색하면서 arr배열에서 개수에 해당하는 인덱스로 곱해줌.
 */

public class BOJ_2302 {
    static int n, m;
    static int[] fix;
    static ArrayList<Integer> temp;
    public static void main(String[] args) throws IOException {
        int ans=1;
        temp = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        fix = new int[m];
        for(int i=0 ; i< m ; i++){
            fix[i]=Integer.parseInt(bf.readLine());
        }
        int now=0;
        for(int i=0 ; i<m ; i++){
            temp.add(fix[i]-now-1);
            now=fix[i];
        }
        temp.add(n-now);
        int max = Collections.max(temp);
        int can[] = new int[max+1];
        for(int i=0 ; i<max+1 ; i++){
            if(i<3){
                can[i]=i;
            }
            else{
                can[i]=can[i-1]+can[i-2];
            }
        }
        for(int i=0 ; i<temp.size() ; i++){
            if(temp.get(i)!=0){
                ans=ans*can[temp.get(i)];
            }
        }
        System.out.println(ans);
    }
}

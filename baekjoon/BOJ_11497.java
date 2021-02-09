import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for(int tc=0 ; tc<testCase ; tc++){
            int T = Integer.parseInt(bf.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            for(int i=0 ; i<T; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            int[] ans = new int[T];
            int cnt=0;
            int size=T-1;
            for(int i=0 ; i<T ; i++){
                ans[cnt]=list.get(i);
                if(i%2==0){
                    cnt+=size--;
                }
                else{
                    cnt-=size--;
                }
            }
            int max=0;
            for(int i=0 ; i<T ; i++){
                if(Math.abs(ans[i]-ans[(i+1)%T])>max) {
                    max=Math.abs(ans[i]-ans[(i+1)%T]);
                }
            }
            System.out.println(max);
        }
    }
}

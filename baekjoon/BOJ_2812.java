import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Character> stk = new Stack<>();
        String num = bf.readLine();
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            list.add(num.charAt(i));
        }
        int cnt=0; //지운횟수
        boolean flag=false;
        for(int u=0 ; u<n ; u++){
            while(!stk.isEmpty() && !flag){
                if(cnt==k) {
                    flag = true;
                    break;
                }
                else{
                    if(num.charAt(u)>stk.peek()){
                        stk.pop();
                        cnt++;
                    }
                    else{
                        break;
                    }
                }
            }
            stk.push(num.charAt(u));
        }
        if(stk.size()!=n-k){
            int temp = stk.size();
            for(int y=0 ; y<temp-(n-k) ; y++){
                stk.pop();
            }
        }
        for(int y=0 ; y<stk.size() ; y++) {
            System.out.print(stk.get(y));
        }
    }
}

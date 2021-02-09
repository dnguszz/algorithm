import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        long ans=0;
        for(int i=0 ; i< n; i++){
            q.offer(Integer.parseInt(bf.readLine()));
        }
        while(q.size()>1){
            int temp=q.poll()+q.poll();
            ans+=temp;
            q.offer(temp);
        }
        System.out.println(ans);
    }
}

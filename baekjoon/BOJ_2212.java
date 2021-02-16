import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2212 {
    static int[] sensor;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());
        if(k>=n){
            System.out.println(0);
            System.exit(0);
        }
        sensor = new int[n];
        int[] cha = new int[n-1];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i=0 ; i<n ; i++){
            sensor[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);
        for(int i=1 ; i<n ; i++){
            cha[i-1]=sensor[i]-sensor[i-1];
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> point = new LinkedList<>();
        int[] tempcha = cha.clone();
        Arrays.sort(tempcha);
        for(int i=0 ; i<k-1 ; i++){
            q.offer(tempcha[tempcha.length-1-i]);
        }
        while(!q.isEmpty()){
            for(int i=0 ; i<n-1 ; i++){
                if(cha[i]==q.peek()){
                    q.poll();
                    point.offer(i);
                    break;
                }
            }
        }
        int ans=0;
        int start=0;
        int size = point.size();
        int end;
        while(!point.isEmpty()){
            end = point.poll();
            ans+=sensor[end]-sensor[start];
            start=end+1;
        }
        ans+=sensor[sensor.length-1]-sensor[start];
        System.out.println(ans);
    }
}

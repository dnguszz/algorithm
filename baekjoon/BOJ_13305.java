import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] dist = new int[n-1];
        int[] oil = new int[n];
        long ans=0;
        StringTokenizer st1 = new StringTokenizer(bf.readLine(), " ");
        for(int i=0 ; i<n-1 ; i++){
            dist[i]=Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
        for(int i=0 ; i<n ; i++){
            oil[i]=Integer.parseInt(st2.nextToken());
        }
        int car=0;
        int price = oil[car];
        for(int i=1 ; i<n ; i++){
            if(oil[i]<price){
                long temp=0;
                for(int j=car ; j<i ; j++){
                    temp+=dist[j];
                }
                ans+=price*temp;
                car=i;
                price=oil[car];
            }
        }
        long temp=0;
        for(int j=car ; j<n-1 ; j++){
            temp+=dist[j];
        }
        ans+=temp*price;
        System.out.println(ans);
    }
}

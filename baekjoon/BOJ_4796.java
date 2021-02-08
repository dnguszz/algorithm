import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt=1;
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l==0 && p==0 && v==0) break;
            int a = v/p;
            int b = v%p;
            int ans=a*l;
            if(b>l) ans+=l;
            else ans+=b;
            System.out.println("Case "+cnt+": "+ans);
            cnt++;
        }
    }
}

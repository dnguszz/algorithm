import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    static int a, b, ans, log;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        ans=-1;
        log=(int) baseLog((double)b/a, 2)+1;
        oper(a, 1);
        System.out.println(ans);

    }

    public static void oper(long n, int cnt){
        if(n==b){
            ans=cnt;
            return;
        }
        if(cnt>log){
            return;
        }
            oper(2*n, cnt+1);
            oper((10*n)+1, cnt+1);

    }

    static double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }

}

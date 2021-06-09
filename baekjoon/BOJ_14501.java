import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
	static int n;
	static int[][] work;
	static int[] money;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		work = new int[n+2][2];
		money = new int[n+2];
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			work[i][0]=Integer.parseInt(st.nextToken()); //소요시간
			work[i][1]=Integer.parseInt(st.nextToken()); //돈
		}
		
		for(int i=1; i<=n + 1; i++){
            for(int j=1; j<i; j++){
                money[i] = Math.max(money[i], money[j]);
                if(j + work[j][0] == i){
                	money[i] = Math.max(money[i], money[j] + work[j][1]);
                }
            }
            ans = Math.max(ans, money[i]);
        }
        System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
	static int from, to;
	static boolean isPrime[];
	static boolean vis[];
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		isPrime = new boolean[10000]; //false면 소수
		isPrime[0]=true;
		isPrime[1]=true;
		for(int i=2; i*i<10000; i++){
        	// prime[i]가 소수라면
            if(!isPrime[i]){
            	for(int j=i*i; j<10000; j+=i) isPrime[j] = true;                
            }        
        }
		
		for (int tc = 0; tc < test; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ans=0;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			vis = new boolean[10000];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {from,0});
			vis[from]=true;
			boolean flag=false;
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int val = temp[0];
				int count = temp[1];
				if(val==to) {
					flag=true;
					ans=count;
					break;
				}
				for (int i = 0; i < 4; i++) {
					StringBuilder tempS = new StringBuilder(Integer.toString(val));
					tempS.setCharAt(i, '0');
					int valT = (int) Math.pow(10, 3-i);
					int tempI = Integer.parseInt(tempS.toString());
					for (int j = 0; j < 10; j++) {
						int tempI2 = tempI+(valT*j);
						if(!isPrime[tempI2] && !vis[tempI2] && tempI2>999 && tempI2<10000) {
							q.offer(new int[] {tempI2, count+1});
							vis[tempI2]=true;
						}
					}
				}
			}
			System.out.println(flag ? ans : "Impossible");
		}
	}
}

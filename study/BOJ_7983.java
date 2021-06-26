import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_7983 {
	static int n;
	static int[][] hw;
	static int todo;
	//일단 제출기한이랑 최대한 맞게 과제를 해야 오래 쉬므로
	//제출기한으로 내림차순 정렬한뒤
	//테케의 1 13이면 13일까지 제출인 과제를 12일에 시작하면댐.
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		hw = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			hw[i][0]= Integer.parseInt(st.nextToken());
			hw[i][1]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(hw, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o2[1]-o1[1];
				else return o2[1]-o1[1];
			}
			
		});
		//초기값 설정해주고
		todo = hw[0][1]-hw[0][0];
		for (int i = 1; i < n; i++) {
			//만약 과제를 시작하는 날이 내림차순배열의 다음 과제제출일보다 빠르다 == 다음과제의 시작일만큼 감소시켜주고
			if(todo<hw[i][1]) todo-=hw[i][0];
			//다음제출일보다 크거나 갖으면 = 영향없으니까 시작일을 초기값과같이 재설정
			else todo = hw[i][1]-hw[i][0];
		}
		System.out.println(todo);
		
	}
}

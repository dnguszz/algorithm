package algo0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
	static int n;
	static int meet[][];
	static int ans=1; //무조건 하나의회의는 들어가므로
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		meet = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(meet, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
		Arrays.sort(meet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		}); //끝나는시간기준으로 오름차순정렬 만약 끝나는시간이같다면 시작시간이 작은거를 앞으로
		int end=meet[0][1]; //가장빨리끝나는회의
		int i=1;
		while(i<n) {
			if(meet[i][0]>=end) {
				end=meet[i][1];
				ans++;
			}
			i++;
		}
		System.out.println(ans);	
	}
}

/*
5
4 4
4 4
3 4
2 4
1 4
 */
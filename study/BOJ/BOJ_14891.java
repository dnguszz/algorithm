import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
	static String[] gear;
	static int k;
	static int[][] oper;
	static int[] point;
	static int[] turn;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		gear = new String[4];
		point = new int[6];
		point[0] = 2;
		point[1] = 6;
		point[2] = 2;
		point[3] = 6;
		point[4] = 2;
		point[5] = 6;
		for (int i = 0; i < 4; i++) {
			gear[i] = bf.readLine();
		}
		k = Integer.parseInt(bf.readLine());
		oper = new int[k][2];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			oper[i][0] = Integer.parseInt(st.nextToken());
			oper[i][1] = Integer.parseInt(st.nextToken());
			turn = new int[4];
			switch (oper[i][0]) {
			case 1:
				turn=turn1(oper[i][1]);
				break;
			case 2:
				turn=turn2(oper[i][1]);
				break;
			case 3:
				turn=turn3(oper[i][1]);
				break;
			case 4:
				turn=turn4(oper[i][1]);
				break;
			}
			for (int j = 0; j < 4; j++) {
				if(turn[j]==1) gear[j]=rot(gear[j]);	
				else if(turn[j]==-1) gear[j]=rotR(gear[j]);
			}
		}
		int cnt=1;
		for (int i = 0; i < 4; i++) {
			ans+=((int) (gear[i].charAt(0)-'0'))*cnt;
			cnt*=2;
		}
		System.out.println(ans);
	}

	public static String rotR(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < 9; i++) {
			sb.append(s.charAt(i % 8));
		}
		return sb.toString();
	}

	public static String rot(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 7; i < 15; i++) {
			sb.append(s.charAt(i % 8));
		}
		return sb.toString();
	}

	public static int[] turn1(int dir) {
		int[] turn = new int[4];
		turn[0] = dir;
		// 0은 안함, 1은 시계, -1 반시계
		if (gear[0].charAt(2) != gear[1].charAt(6))
			turn[1] = turn[0] * -1;
		if (gear[1].charAt(2) != gear[2].charAt(6))
			turn[2] = turn[1] * -1;
		if (gear[2].charAt(2) != gear[3].charAt(6))
			turn[3] = turn[2] * -1;
		return turn;
	}

	public static int[] turn2(int dir) {
		int[] turn = new int[4];
		turn[1] = dir;
		// 0은 안함, 1은 시계, -1 반시계
		if (gear[1].charAt(6) != gear[0].charAt(2))
			turn[0] = turn[1] * -1;
		if (gear[1].charAt(2) != gear[2].charAt(6))
			turn[2] = turn[1] * -1;
		if (gear[2].charAt(2) != gear[3].charAt(6))
			turn[3] = turn[2] * -1;
		return turn;
	}

	public static int[] turn3(int dir) {
		int[] turn = new int[4];
		turn[2] = dir;
		// 0은 안함, 1은 시계, -1 반시계
		if (gear[2].charAt(6) != gear[1].charAt(2))
			turn[1] = turn[2] * -1;
		if (gear[1].charAt(6) != gear[0].charAt(2))
			turn[0] = turn[1] * -1;
		if (gear[2].charAt(2) != gear[3].charAt(6))
			turn[3] = turn[2] * -1;
		return turn;
	}

	public static int[] turn4(int dir) {
		int[] turn = new int[4];
		turn[3] = dir;
		// 0은 안함, 1은 시계, -1 반시계
		if (gear[3].charAt(6) != gear[2].charAt(2))
			turn[2] = turn[3] * -1;
		if (gear[1].charAt(2) != gear[2].charAt(6))
			turn[1] = turn[2] * -1;
		if (gear[0].charAt(2) != gear[1].charAt(6))
			turn[0] = turn[1] * -1;
		return turn;
	}
}

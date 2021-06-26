import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8972 {
	static int r, c;
	static char[][] map;
	static String command;
	static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int count = 0;
	static ArrayList<int[]> robot;
	static int[] player;
	static int[][] amount;
	static int moveCount;
	static char[][] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c]; //초기 배열
		robot = new ArrayList<>(); //미친 아두이노들의 좌표가 담긴 리스트
		player = new int[2]; //내 아두이노 좌표
		amount = new int[r][c]; //현재칸에 미친아두이노가 몇개있는지 담는 배열
		for (int i = 0; i < r; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'R') {
					count++;
					robot.add(new int[] { i, j });
					amount[i][j]++;
				}
				if (map[i][j] == 'I') {
					player[0] = i;
					player[1] = j;
				}
			}
		}
		//초기입력 다받고
		command = bf.readLine(); //명령어 입력받고 처리
		for (int i = 0; i < command.length(); i++) {
			moveCount++; //만약 게임오버시에 출력용으로 몇번이동했는지 담는 변수
			int temp = (int) command.charAt(i) - '0'; 
			player[0] += dx[temp];
			player[1] += dy[temp]; // 플레이어 이동시켜주고
			for (int j = 0; j < robot.size(); j++) {
				int min = 999999;
				int minNum = 0; //몇번째방향인지
				for (int k = 1; k < 10; k++) {
					int robotmoveX = robot.get(j)[0] + dx[k];
					int robotmoveY = robot.get(j)[1] + dy[k];
					int dist = Math.abs(player[0] - robotmoveX) + Math.abs(player[1] - robotmoveY);
					if (dist < min) {
						min = dist;
						minNum = k;
					}
				}//로봇 문제대로 이동시켜주고
				amount[robot.get(j)[0]][robot.get(j)[1]]--; //원래칸의 로봇수 1 빼고
				robot.get(j)[0] += dx[minNum];
				robot.get(j)[1] += dy[minNum];
				amount[robot.get(j)[0]][robot.get(j)[1]]++; //이동한칸 로봇수 1 증가
			}
			
			// 모든 로봇이동끝남
			
			isend(); //로봇이랑 플레이어 닿았는지 검사
			isBomb(); //터지는거있는지 검사
		}
		
		//모든 이동 끝남
		ans = new char[r][c]; 
		for (int i = 0; i < r; i++) {
			Arrays.fill(ans[i], '.');
		}
		ans[player[0]][player[1]]='I';
		for (int i = 0; i < robot.size(); i++) {
			ans[robot.get(i)[0]][robot.get(i)[1]]='R';
		}
		//출력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}

	}

	
	private static void isend() {
		for (int i = 0; i < robot.size(); i++) { //미친아두이노 위치담긴 배열 탐색하면서 내 아두이노랑 겹치는지
			if(robot.get(i)[0]==player[0] && robot.get(i)[1]==player[1]) {
				System.out.print("kraj ");
				System.out.println(moveCount);
				System.exit(0);
			}
		}
		
	}

	private static void isBomb() {
		for (int R = 0; R < r; R++) {
			for (int C = 0; C < c; C++) {
				if(amount[R][C]>1) { //amount배열 처음부터끝까지 돌면서 그칸에 미친아두이노 2개이상 있으면
					for (int i = 0; i < robot.size(); i++) {
						if(robot.get(i)[0]==R && robot.get(i)[1]==C) { //그 미친아두이노 찾고
							robot.remove(i); //없애고
							i--;
							amount[R][C]--; //개수 감소
						}
					}
				}
			}
		}
	}
}

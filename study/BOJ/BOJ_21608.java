package algo0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21608 {
	static int n, n2; //자리 행, 열 수랑 학생 수
	static int result[][]; //자리 저장할 배열
	static int ans=0; //결과
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static ArrayList<ArrayList<Integer>> list; //학생이 선호하는 학생 인접리스트로
	static ArrayList<Integer> order; //순서
	static int[] cal = new int[5]; //주위에 몇명있는지 저장용
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		order = new ArrayList<>();
		n = Integer.parseInt(bf.readLine());
		n2 = (int) Math.pow(n, 2);
		for (int i = 0; i < n2+1; i++) {
			list.add(new ArrayList<>());
		}
		result = new int[n][n];
		for (int i = 0; i < n2; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int temp = Integer.parseInt(st.nextToken());
			order.add(temp);
			for (int j = 0; j < 4; j++) {
				list.get(temp).add(Integer.parseInt(st.nextToken()));
			}
		} //입력부
		
		for (int i = 0; i < order.size(); i++) { //입력받은 순서대로 자리 배치
			int x=0;
			int y=0;
			int max=-999;
			int temp = order.get(i); //이 학생을 어따배치할건지
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) { //자리 처음부터 끝까지 돕니다 (3번조건)
					if(result[j][j2]==0) { //빈자리일때만
						int fri = findLike(j,j2, temp); //주위에 선호학생 몇명인지 계산
						if(fri>max) { //선호학생이 이전자리보다 많은경우 무조건 그자리에 배치(1번조건)
							x=j; 
							y=j2;
							max=fri;
						}
						if(fri==max) { //만약 선호학생수 같으면
							int temp1 = findvoid(x,y);
							int temp2 = findvoid(j,j2); //이전자리와 현재자리의 주위 빈공간을 계산해서
							if(temp2>temp1) { //현재자리의 빈공간이 많을경우 갱신(2번조건)
								x=j;
								y=j2;
							}
						}
						
					}
				}
			}
			result[x][y]=temp; //그자리에 학생 배치
		}
		
		for (int i = 0; i < n; i++) { //이제 값 구할차례
			for (int j = 0; j < n; j++) {
				int temp = result[i][j];
				int tempR=0;
				for (int k = 0; k < 4; k++) {
					if(i+dx[k]>=0 && i+dx[k]<n && j+dy[k]>=0 && j+dy[k]<n) {
						if(list.get(temp).contains(result[i+dx[k]][j+dy[k]])) tempR++;
					} //맵의 모든부분 돌면서 그자리에 위치한 학생이 선호하는 학생이 몇명인지 계산해서
				}
				cal[tempR]++; //배열에 해당부분 플러스
			}
		}
		int mult=1;
		for (int i = 1; i < 5; i++) { //0일때는 0점이므로 고려 ㄴ
			ans+=cal[i]*mult; //0일때0, 1일때1, 2일때 10.. 이렇게 증가하므로 mult 1부터 곱해주면서
			mult*=10; //10배씩
		}
		System.out.println(ans);
	}
	
	public static int findLike(int x, int y, int a) { //선호학생수 구하는 메소드
		int ans=0;
		for (int i = 0; i < 4; i++) {
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {
				if(list.get(a).contains(result[x+dx[i]][y+dy[i]])) ans++;
				
			}
		}
		return ans;
	}
	public static int findvoid(int x, int y) { //빈칸 구하는 메소드
		int ans=0;
		for (int i = 0; i < 4; i++) {
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n) {
				if(result[x+dx[i]][y+dy[i]]==0) ans++;
			}
		}
		return ans;
	}
}

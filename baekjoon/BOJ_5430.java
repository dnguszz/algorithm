import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_5430 {
	static int test;
	static int n;
	static Deque<Integer> dq;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < test; tc++) {
			dq = new ArrayDeque<>();
			String oper = bf.readLine();
			n = Integer.parseInt(bf.readLine());
			String temp = bf.readLine();
			temp=temp.replace("[", "");
			temp=temp.replace("]", ""); //끝에 괄호 제거
			String[] tempVal = temp.split(",");
			//덱에 추가
			for (int i = 0; i < n; i++) {
				dq.offerLast(Integer.parseInt(tempVal[i]));
			}
			boolean dir=true; //트루면 정방향, false면 역방향
			boolean isErr = false; //에러가 발생했는지 판단하는 변수
			for (int i = 0; i < oper.length(); i++) {
				if(oper.charAt(i)=='R') dir = !dir; //리버스명령이면 방향 바꿔주고
				else { //oper.charAt(i)=='D'
					if(dq.isEmpty()) { //비어있을때
						sb.append("error\n");
						isErr=true;
						break;
					}
					if(dir) { //정방향
						dq.pollFirst();
					}
					else { //역방향
						dq.pollLast();
					}
				}
			}
			//출력부
			if(isErr) {
				continue; //다음 테스트케이스로
			}
			else {
				sb.append("[");
				if(dir) {//정방향
					while(!dq.isEmpty()) {
						sb.append(dq.pollFirst());
						if(!dq.isEmpty()) {
							sb.append(","); //마지막이 아닐때만 콤마 안붙이고 ㅎㅎ
						}
					}
				}
				else { //역방향
					while(!dq.isEmpty()) {
						sb.append(dq.pollLast());
						if(!dq.isEmpty()) {
							sb.append(","); //마지막이 아닐때만 콤마 안붙이고 ㅎㅎ
						}
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}

import java.util.ArrayList;

class Solution {
    static boolean[] vis;
	static int[] arr;
	static ArrayList<Long> num;
	static ArrayList<Integer> oper;
	static long answer=-999999;
    public long solution(String expression) {
        vis = new boolean[3];
		arr = new int[3];
		
		num = new ArrayList<>(); //숫자 담을 리스트
		oper = new ArrayList<>(); //연산자 담는 리스트
		/*
		 * +=1
		 * -=2
		 * *=3
		 */
		String ex1 = expression.replace('+', '@');
		ex1 = ex1.replace('-', '@');
		ex1 = ex1.replace('*', '@'); //원본에서 연산자 하나로 통일하고
		
		String[] exTemp = ex1.split("@"); //숫자만 쪼개서
		for (int i = 0; i < exTemp.length; i++) {
			num.add(Long.parseLong(exTemp[i])); //리스트에 저장
		}
		
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)=='+') oper.add(1);
			if(expression.charAt(i)=='-') oper.add(2);
			if(expression.charAt(i)=='*') oper.add(3); //연산자도 리스트에 따로 저장
		}
		P(0); //1~3까지 순서대로완탐
        return answer;
    }
    
    public static void P(int cnt) {
		if(cnt==3) {
			long ans=0;
			ArrayList<Long> numT = new ArrayList<>(num);
			ArrayList<Integer> operT = new ArrayList<>(oper); //원본리스트 복사하고
			//항상 숫자는 연산자보다 1개 많음
			for (int j = 0; j < 3; j++) { //연산순서를 순서대로 돌면서
				for (int i = 0; i < operT.size(); i++) {
					if(operT.get(i)==arr[j]) {//만약 연산자리스트의 i번째 연산자를 수행한다하면
						switch(arr[j]) {
						case 1:
							numT.set(i, numT.get(i)+numT.get(i+1));
							numT.remove(i+1);
							operT.remove(i); //숫자의 i번째와 i+1번째를 연산해주고 i+1번째거 삭제, 연산자도 수행했으니 삭제
							break;
						case 2:
							numT.set(i, numT.get(i)-numT.get(i+1));
							numT.remove(i+1);
							operT.remove(i);
							break;
						case 3:
							numT.set(i, numT.get(i)*numT.get(i+1));
							numT.remove(i+1);
							operT.remove(i);
							break;
						}
                        i--; //수행이 됬다 = 연산자가 하나 삭제되었다 = i는 그대로
					}
				}
			}
			
			if (Math.abs(numT.get(0))>answer) answer=Math.abs(numT.get(0)); //이렇게 구해진값 비교해서 answer에 저장
		}
		for (int i = 0; i < 3; i++) {
			if(vis[i]) continue;
			arr[cnt]=i+1;
			vis[i]=true;
			P(cnt+1);
			vis[i]=false;
		}
	}
}

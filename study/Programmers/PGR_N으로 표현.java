import java.util.ArrayList;

class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer> list[] = new ArrayList[9];
		for (int i = 1; i < 9; i++) {
			list[i]= new ArrayList<>();
		} //8보다 많이 필요한경우는 -1리턴이므로 8개만생성
		list[1].add(N); //1로만드는거는 N그자체니까 넣어준다
		int ans = -1; //리턴할값, -1로초기화
		int count = 1;
		boolean flag = false;
		while (count < 9) { //반복문시작
			if(count>=2) { //카운트가 1일때는 아래꺼 할 필요가없음
				for (int j = 1; j < count; j++) {
					for (int i = 0; i < list[j].size(); i++) {
						for (int k = 0; k < list[count-j].size(); k++) {
							list[count].add(list[j].get(i)+list[count-j].get(k));
							if(list[j].get(i)-list[count-j].get(k)>=0) list[count].add(list[j].get(i)-list[count-j].get(k));
							if(list[count-j].get(k)-list[j].get(i)>=0) list[count].add(list[count-j].get(k)-list[j].get(i));
							list[count].add(list[j].get(i)*list[count-j].get(k));
							if(list[count-j].get(k)!=0) list[count].add(list[j].get(i)/list[count-j].get(k));
							if(list[j].get(i)!=0) list[count].add(list[count-j].get(k)/list[j].get(i));
						}
					}
				} //반복문인데... 설명할수가없음 현재 카운트를 2개로 나눌수있는값들끼리 사칙연산
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < count; i++) {
					sb.append("1");
				}
				String sbs = sb.toString();
				int sbt = Integer.parseInt(sbs);
				list[count].add(sbt * N); //55,555, 5555 넣기위해 스트링으로함
			}
			//여까지하면 리스트생성완료
			for (int i = 0; i < list[count].size(); i++) {
				if (list[count].get(i) == number) {
					ans = count;
					flag = true;
					break;
				}
			} //탐색해서 number포함하면 ans에 카운트 저장시키고 while문 탈출을 위한 flag true로
			if (flag) break; //탐색해서 원하는값 나왔으면 반복문탈출
			count++; //못찾았으면 카운트증가, 8까지만
		}
		return ans;
    }
}

//숫자 5가있다
//
//5+5=10
//5/5=1
//5*5=25
//
//우선 만들수있는거는 10,1,25(기본적으로) 11, 111, 1111...
//12, 13, 14... 그리고 112, 1113, 1114...
//라고하면
//1 10 11 25 
//테케는
//10 1 1
//11 1
//60/5
//
//1만들때 5/5=2
//2만들때  
//
//2 4 6 8 1 3 5 7 9 2
//1 5/5 = 2
//2 5/5+5/5 = 4
//3 5/5+5/5+5/5 =6
//4 =8
//5 =1
//6 5+5/5 = 3
//7 5+5/5+5/5 = 5
//8 5+5/5+5/5+5/5 = 7
//9 5+5/5+5/5+5/5+5/5 = 9
//10 5+5 = 2
//11 55/5 = 3
//12 = 4
//13 = 5
//14 = 6
//15 = 3
//16 = 5+5+5+5/5 = 5
//
//1부터 N까지는 2*n
//N이 n으로 나눠질때는 N/n
//11부터는 3~
//포기

//다음접근법
//N이 n개있을때 만들수있는 숫자
//
//1개
//5
//2개
//5+5 5-5 5*5 5/5 55 = 5개
//3개
//1개에 2개 사칙연산한거, 나눗셈이랑 뺄셈은 순서바꿔서 2번씩 + 555
//4개
//1개에 3개 사칙연산한거, 2개에 2개, 3에1 + 5555 ... 

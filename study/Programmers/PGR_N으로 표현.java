import java.util.ArrayList;

class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer> list[] = new ArrayList[9];
		for (int i = 1; i < 9; i++) {
			list[i]= new ArrayList<>();
		}
		list[1].add(N);
		int ans = -1;
		int count = 1;
		boolean flag = false;
		while (count < 9) {
			if(count>=2) {
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
				}
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < count; i++) {
					sb.append("1");
				}
				String sbs = sb.toString();
				int sbt = Integer.parseInt(sbs);
				list[count].add(sbt * N);
			}
			for (int i = 0; i < list[count].size(); i++) {
				if (list[count].get(i) == number) {
					ans = count;
					flag = true;
					break;
				}
			}
			if (flag) break;
			count++;
		}
		return ans;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashMap<String, Integer> hs = new HashMap<>(); //각 보석의 개수
		HashMap<String, Integer> hsIndex = new HashMap<>(); //각 보석의 위치
		ArrayList<int[]> list = new ArrayList<>();
		int size = 0;
		for (int i = 0; i < gems.length; i++) {
			if (hs.get(gems[i]) == null) {
				hs.put(gems[i], 1);
				size++;
			} else {
				hs.put(gems[i], hs.get(gems[i]) + 1);
			}
		} //배열 탐색하면서 해쉬의 키가 보석인곳 1씩 증가, 보석의 종류도 1씩증가
		for (int i = 0; i < gems.length; i++) { //배열 돌면서
			hsIndex.put(gems[i], i); //i번째배열에 해당하는 보석을 키로 같는 해시에 밸류로 위치 집어넣고
			if (hsIndex.size() == size) { //만약 해쉬의 크기가 보석종류만큼이면(모든 보석 다 갖고있으면)
				int min = 999999;
				int max = -99999;
				Set set = hsIndex.keySet();
				Iterator iterator = set.iterator();

				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					int temp = hsIndex.get(key);
					if (temp > max)
						max = temp;
					if (temp < min)
						min = temp;
				}
				list.add(new int[] {min, max}); //리스트에 시작점과 끝을 담는 배열 집어넣음
				
			}
		}
		Collections.sort(list, new Comparator<int[]>() { //정렬, 1. 시작과끝의 차가 작은순, 2.만약 같다면 시작점이 작은순으로

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]-o1[0] == o2[1]-o2[0]) {
					return o1[0]-o2[0];
				}
				return (o1[1]-o1[0]) - (o2[1]-o2[0]);
			}
		});
        answer[0]=list.get(0)[0]+1;
        answer[1]=list.get(0)[1]+1;
        return answer;
    }
}

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String word) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i <= 55555; i++) {
			String temp = Integer.toString(i);
			if(temp.contains("0") || temp.contains("6") || temp.contains("7") || temp.contains("8") || temp.contains("9")) {
				continue;
			}
			list.add(temp);
		}
		Collections.sort(list);
		System.out.println(list);
		
		word = word.replaceAll("A", "1");
		word = word.replaceAll("E", "2");
		word = word.replaceAll("I", "3");
		word = word.replaceAll("O", "4");
		word = word.replaceAll("U", "5");
        
        answer = list.indexOf(word)+1;
        
        return answer;
    }
}

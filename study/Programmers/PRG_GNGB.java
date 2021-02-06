import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PRG_GNGB {
    public static void main(String[] args){
        int[] progresses ={93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(); //q에는 각 작업이 끝나는데 필요한 일수 저장
        for(int i=0 ; i<progresses.length ; i++) {
            int day=1;
            while(progresses[i]+(day*speeds[i])<100) { //작업진도에 작업속도*일수를 더한 값이 100을 넘길때까지 반복
                day++;
            }
            q.offer(day);
        } //큐에 [7,3,9] 저장
        ArrayList<Integer> list = new ArrayList<>(); //배포마다 몇개의 기능이 배포되는지 저장하는 리스트
        while(!q.isEmpty()){ //q가 빌때까지 루프돌립니다
            int service=1; //배포마다 service만큼의 기능이 배포됨
            int temp = q.poll(); //큐의 맨 아래값을 임시로 저장

            //q.poll()이 temp보다 작거나같은값으면 그 작업은 temp와 같이 배포됨. 이때마다 serviec를 1씩 늘림
            //q가 비거나 q.poll()이 temp보다 클때까지 반복
            while(!q.isEmpty()){
                if(q.peek()<=temp){
                    service++;
                    q.poll();
                }
                else break;
            }
            //
            list.add(service); //각배포마다 배포되는 기능의 수를 리스트에 추가
        }

        //답이 담겨있는 리스트를 정수배열로 변환
        int[] answer = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            answer[i]=list.get(i);
        }
        //**이부분 반복말고 다른방법으로 가능할까요?**
        return answer;
    }
}
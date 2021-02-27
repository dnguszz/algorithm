import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_1377 {
    static int n, ans;
    static int[] arr;
    static HashMap<Integer, Integer> before;
    static HashMap<Integer, Integer> after;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        before = new HashMap<>();
        after = new HashMap<>();
        ans=0;
        arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            arr[i]=Integer.parseInt(bf.readLine()); //배열에 저장
            before.put(arr[i], i); //정렬안된 값이 배열의 어느 인덱스에 있는지
        }
        Arrays.sort(arr); //정렬함
        for(int i=0 ; i<n ; i++){
            after.put(arr[i], i); //정렬된 값이 배열의 어느 인덱스에 있는지
        }
        for(int i=0 ; i<n ; i++){
            list.add(before.get(arr[i])-after.get(arr[i]));
        } //출력값은 버블솔트시 바꾸는 과정이 일어나는 수 +1 임
        System.out.println(list);
        // 수를 사이클이라 하면 큰 수는 한 사이클에서 여러 칸 뒤로 이동가능함 = 리스트의 음수는 이 수가 뒤로갔다는 뜻
        // 반대로 작은수가 앞으로 가는 경우는 한 사이클에서 한칸씩만임 = 리스트의 양수중 가장 큰 값이 버블소트에서 사이클이 일어난 횟수
        System.out.println(Collections.max(list)+1);
    }
}

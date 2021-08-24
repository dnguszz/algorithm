import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {
	static int n, m;
	static ArrayList<Integer> crain, box;
	static int Cmax=-1;
	static int Bmax=-1;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		crain = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			crain.add(Integer.parseInt(st.nextToken()));
			if(crain.get(i)>Cmax) Cmax=crain.get(i);
		}
		box = new ArrayList<>();
		m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
			if(box.get(i)>Bmax) Bmax=box.get(i);
		}
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		//-1 검증
		if(Bmax>Cmax) {
			System.out.println(-1);
			System.exit(0);
		}
        while(!box.isEmpty()) {
            int idx = 0;
            for(int i = 0; i < crain.size();) {
                if(idx == box.size()) break;
                else if(crain.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                }
                else idx++;
            }
            ans++;
        }
        System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
	static int n, n2;
	static int[] arr, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        n2 = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        arr2 = new int[n2];
        for(int i=0 ; i<n2 ; i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n2; i++) {
            System.out.println(((eb(arr2[i], arr)) ? "1" : "0"));
        }
    }
    public static boolean eb(int a, int[] b) {
        int end = b.length-1;
        int start = 0;
        while(end>=start){
            int mid = (start+end)/2;
            if(a==b[mid]){
                return true;
            }
            else if(a<b[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
}

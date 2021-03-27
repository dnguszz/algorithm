package algo2021_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_7560 {
    static int n;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test =  Integer.parseInt(bf.readLine());
        for (int tc=1 ; tc<= test ; tc++){
            n = Integer.parseInt(bf.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i=0 ; i<n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            ans=arr[0];
            for (int i=1 ; i<n ; i++){
                arr[i]=arr[i]+arr[i-1];
                ans+=arr[i];
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}

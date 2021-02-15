import java.io.*;
import java.util.*;

public class BOJ_1041 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(bf.readLine());
        long ans=0;
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i=0 ; i<6 ; i++) {
            dice[i]=Integer.parseInt(st.nextToken());
        }
        if(n==1) {
            Arrays.sort(dice);
            for(int i=0 ; i<5 ; i++) {
                ans+=dice[i];
            }
            System.out.println(ans);
        }
        else {
            long one=4*(n-1)*(n-2)+((n-2)*(n-2));
            long two=4*(n-2)+4*(n-1);
            int[] newDice = dice.clone();
            Arrays.sort(newDice);
            int min1 = newDice[0];
            int min2=0;
            min2=Math.min(Math.min(Math.min(dice[0], dice[5])+Math.min(dice[1], dice[4]),Math.min(dice[2], dice[3])+
                    Math.min(dice[1], dice[4])),Math.min(dice[2], dice[3])+Math.min(dice[0], dice[5]));
            int min3=0;
            min3+=Math.min(dice[0], dice[5]);
            min3+=Math.min(dice[1], dice[4]);
            min3+=Math.min(dice[2], dice[3]);
            ans+=(long) min1*one;
            ans+=(long) min2*two;
            ans+=min3*4;
            System.out.println(ans);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2138 {
    static boolean[] state;
    static boolean[] result;
    static int ans1, ans2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boolean[] caseflag = new boolean[2];
        state = new boolean[n];
        result = new boolean[n];
        String str = bf.readLine();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') state[i] = true;
        }
        String str2 = bf.readLine();
        for (int i = 0; i < n; i++) {
            if (str2.charAt(i) == '1') result[i] = true;
        }
        boolean[] tempState = state.clone();
        boolean[] tempResult = result.clone();
        swit(0);
        ans1 = 1;
        ans2 = 0;
        for (int i = 1; i < state.length; i++) {
            if (equa(state, result)) {
                caseflag[0] = true;
                break;
            }
            if (state[i-1] != result[i-1]) {
                ans1++;
                swit(i);
            }
        }
        if (equa(state, result)) {
            caseflag[0] = true;
        }
        state = tempState.clone();
        result = tempResult.clone();
        for (int i = 1; i < state.length; i++) {
            if (equa(state, result)) {
                caseflag[1] = true;
                break;
            }
            if (state[i-1] != result[i-1]) {
                ans2++;
                swit(i);
            }
        }
        if (equa(state, result)) {
            caseflag[1] = true;
        }

        if(caseflag[0] && !caseflag[1]) System.out.println(ans1);
        else if(caseflag[1] && !caseflag[0]) System.out.println(ans2);
        else if(caseflag[1] && caseflag[0]) System.out.println(Math.min(ans1, ans2));
        else if(!caseflag[1] && !caseflag[0]) System.out.println(-1);
    }

    public static void swit(int i) {
        if (i == 0) {
            state[i] = !state[i];
            state[i + 1] = !state[i + 1];
        } else if (i == state.length - 1) {
            state[i] = !state[i];
            state[i - 1] = !state[i - 1];
        } else {
            state[i - 1] = !state[i - 1];
            state[i] = !state[i];
            state[i + 1] = !state[i + 1];
        }
    }
    public static boolean equa(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

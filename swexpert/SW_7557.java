package algo2021_03;

import java.io.*;
import java.util.*;

public class SW_7557 {
    static int n;
    static Integer[] arr;
    static ArrayList<Integer> list;
    static ArrayList<Integer> l1;
    static ArrayList<Integer> l2;
    static int ansF;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ansF = 0;
        list = new ArrayList<>();
        n = Integer.parseInt(bf.readLine());
        arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        ArrayList<Integer> lis1 = new ArrayList<>();
        ArrayList<Integer> lis2 = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i <= max; i++) {
            int temp = count(i);
            if (temp == 2) {
                lis1.add(i);
                lis2.add(i);
            } else if (temp > 2) {
                flag = false;
            } else if (temp == 1) {
                lis1.add(i);
            }
        }
        if (!check(lis1)) flag = false;
        if (!check(lis2)) flag = false;
        for (int i = 0; i <= max; i++) {
            if (lis1.contains(i) && lis2.contains(i)) ansF++;
        }
        int Fans = 0;
        if (flag) {
            if (lis2.isEmpty()) {
                Fans = 2;
            } else if (lis2.containsAll(lis1)) {
                Fans = Fans = (int) Math.pow(2, ansF);
            } else {
                Fans = (int) Math.pow(2, ansF + 1);
            }
        }
        System.out.println(Fans);
    }

    public static int count(int a) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) ans++;
        }
        return ans;
    }

    public static boolean check(ArrayList<Integer> list) {
        if (list.isEmpty()) return true;
        if (list.get(0) != 0) return false;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i - 1) + 1) return false;
        }
        return true;
    }
}

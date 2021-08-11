import java.util.Scanner;

public class BOJ_1371 {
	static String s;
	static int[] arr;
	static int max=-1;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		arr = new int[26];
		while(sc.hasNextLine()){
            s=sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
            	if(s.charAt(i)!=' ') {
            		arr[s.charAt(i)-'a']++;
            		if(max < arr[s.charAt(i) - 'a']) max = arr[s.charAt(i) - 'a'];
            	}
			}
        }
		for(int i = 0; i < 26; i++){
            if(arr[i] == max) System.out.print((char)(i + 'a'));
        }
	}
}

import java.io.*;
import java.util.Arrays;

public class BOJ_4779_new {
    static int n, N;
    static char[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String input="";

        while((input=bf.readLine())!=null){
            n = Integer.parseInt(input);
            N = (int) Math.pow(3, n);
            str = new char[N];
            Arrays.fill(str, '-');
            kantona(0, (int) (Math.pow(3, n)-1), n);
            for(int i=0 ; i< str.length ; i++){
                bw.write(str[i]);

            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static void kantona(int start, int end, int n){
        if (n==0) return;
        else{
            for(int i=start+(end-start+1)/3 ; i<start+(2*(end-start+1)/3) ; i++){
                str[i]=' ';
            }
            kantona(start,end-(int) (2*Math.pow(3,n-1)), n-1);
            kantona(start+(int) (2*Math.pow(3,n-1)),end, n-1);
        }

    }
}

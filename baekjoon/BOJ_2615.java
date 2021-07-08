import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(map[i][j]==0) continue;
				win1(map[i][j],i,j,1);
				win2(map[i][j],i,j,1);
				win3(map[i][j],i,j,1);
				win4(map[i][j],i,j,1);
			}
		}
		System.out.println(0);
	}
	
	public static boolean win1(int egg, int x, int y, int cnt) {
		if(cnt>5) return false;
		if(cnt==1 && y-1>=0 && map[x][y-1]==egg) return false;
		if(cnt==5 && y+1<19 && map[x][y+1]!=egg) {
			System.out.println(egg);
			System.out.print(x+1);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(cnt==5 && (y+1>=19)) {
			System.out.println(egg);
			System.out.print(x+1);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(y+1>=0 && y+1<19) {
			if(map[x][y+1]==egg) {
				win1(egg,x,y+1,cnt+1);
			}
			else return false;
		}
		return false;
	}
	public static boolean win2(int egg, int x, int y, int cnt) {
		if(cnt>5) return false;
		if(cnt==1 && x-1>=0 && map[x-1][y]==egg) return false;
		if(cnt==5 && x+1<19 && map[x+1][y]!=egg) {
			System.out.println(egg);
			System.out.print(x-3);
			System.out.print(" ");
			System.out.print(y+1);
			System.exit(0);
		}
		if(cnt==5 && x+1>=19) {
			System.out.println(egg);
			System.out.print(x-3);
			System.out.print(" ");
			System.out.print(y+1);
			System.exit(0);
		}
		if(x+1>=0 && x+1<19) {
			if(map[x+1][y]==egg) {
				win2(egg,x+1,y,cnt+1);
			}
			else return false;
		}
		return false;
	}
	
	public static boolean win3(int egg, int x, int y, int cnt) {
		if(cnt>5) return false;
		if(cnt==1 && x-1>=0 && y-1>=0 && map[x-1][y-1]==egg) return false;
		if(cnt==5 && x+1<19 && y+1<19 && map[x+1][y+1]!=egg) {
			System.out.println(egg);
			System.out.print(x-3);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(cnt==5 && (x+1>=19 || y+1>=19)) {
			System.out.println(egg);
			System.out.print(x-3);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(y+1>=0 && y+1<19 && x+1>=0 && x+1<19) {
			if(map[x+1][y+1]==egg) {
				win3(egg,x+1,y+1,cnt+1);
			}
			else return false;
		}
		return false;
	}
	public static boolean win4(int egg, int x, int y, int cnt) {
		if(cnt>5) return false;
		if(cnt==1 && x+1<19 && y-1>=0 && map[x+1][y-1]==egg) return false;	
		if(cnt==5 && x-1>=0 && y+1<19 && map[x-1][y+1]!=egg) {
			System.out.println(egg);
			System.out.print(x+5);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(cnt==5 && (x-1<0 || y+1>19)) {
			System.out.println(egg);
			System.out.print(x+5);
			System.out.print(" ");
			System.out.print(y-3);
			System.exit(0);
		}
		if(y+1<19 && x-1>=0) {
			if(map[x-1][y+1]==egg) {
				win4(egg,x-1,y+1,cnt+1);
			}
			else return false;
			
		}
		return false;
	}
}

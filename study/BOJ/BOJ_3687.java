package algo0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3687 {
	static int n;
	static long[] min; 
	static long[] tempmin;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		min = new long[101]; //n개의 성냥으로 만들수있는 최소값
		tempmin = new long[10]; //위에거랑 비슷한데 6개의경우 최소는 0이지만 맨앞에 놀수없어서 새로 만들었음
		min[2]=1;
		min[3]=7;
		min[4]=4;
		min[5]=2;
		min[6]=6;
		min[7]=8;
		min[8]=10; //8까지는 쉽게 구할수있으므로 미리 저장해놓고
		
		tempmin[2]=1;
		tempmin[3]=7;
		tempmin[4]=4;
		tempmin[5]=2;
		tempmin[6]=0;
		tempmin[7]=8;
		tempmin[8]=10;
		for (int i = 9; i < 101; i++) {
			min[i]=Long.MAX_VALUE; //Math.min할거기때문에 큰값으로 전부 초기화
		}
		for (int i = 9; i < 101; i++) {
			/*
			 * 만약 9개로만든다하면 일단 두자리수임, 그니까
			 * 7개 2개 / 6개 3개/ 5개4개/ 4개5개/... 이렇게 구성될텐데 규칙 아무리해도 안보임 근데 어차피 100개밖에 안되니 전부 계산해보기로함
			 * 
			*/
			for (int j = 2; j < 8; j++) {
				min[i]=Math.min(min[i], min[i-j]*10+tempmin[j]); //마지막 더하는부분이 tempmin이 아니라 min이면 0이아닌 6이들어갈거임
			}
		}
		//101까지 최소값 생성함
		for (int tc = 1; tc <= test; tc++) {
			//최대값은 테스트케이스안에서구함
			StringBuffer max = new StringBuffer(); //최대값담을 스트링버퍼, long으로해봤는데 안되서 이걸로함
			n = Integer.parseInt(bf.readLine());
			//성냥1개로만들수있는거 없음
			//성냥 2개로 가능한 최대 1
			//성냥 3개로 가능한 최대 7
			//4개 이상부터는 성냥2개+성냥2개 이렇게 자릿수를 늘려줌
			//고로 성냥이 짝수개면 개수/2의 값만큼 1을 붙여주고
			//홀수면 3222.. 이런식으로 개수/2에서 1뺀거만큼 1붙이고 맨앞에 7붙이면 최대값
			if(n%2==0) {
				int mok = n/2;
				//max=0;
				for (int i = 0; i < mok; i++) {
					max.append("1");
				}
			}
			else {
				max.append("7");
				int mok = (n/2)-1;
				for (int i = 0; i < mok; i++) {
					max.append("1");
				}
				
			} //계산끝
			System.out.println(min[n]+" "+max.toString());
		}
	}
}

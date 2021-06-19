public class PGR620 {
	static int n=6;
	static int[] times = {7,10};
	public static void main(String[] args) {
		long start = 1;
		long end = 10000;
		long ans=1;
		long temp=0;
		long realans=Long.MAX_VALUE-100;
		while(start!=end) {
			ans = (start+end)/2;
			temp=0;
			for (int i = 0; i < times.length; i++) {
				temp+= ans/times[i];
			}
			if(temp==n) {
				end=ans;
				if(ans<realans) realans = ans;
			}
			else if(temp>n) {
				end = ans-1;
			}
			else {
				start = ans+1;
			}
		}
		System.out.println(realans);
	}
}

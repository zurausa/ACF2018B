import java.io.PrintWriter;

public class MainB {
	static FastScanner sc;
	static PrintWriter out;
	public static void main(String[] args){
		sc = new FastScanner();
		out = new PrintWriter(System.out);
//		solve();
		out.println(solve());
		out.flush();
	}

	static int solve(){
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] mat1List = new int[N];
		int[] mat2List = new int[N];
		int max =0;
		int idx = 0;
		for(int i=0;i<N;i++){
			mat1List[i] = sc.nextInt();
			mat2List[i] = sc.nextInt();
			max += mat1List[i]*mat2List[i];
			if(mat2List[idx] < mat2List[i])idx = i;
		}
		if(X==0) return max;
		max = 0;
		for(int i=0;i<N;i++){
			if(i==idx) max+=(mat1List[i]+X)*mat2List[i];
			else max += mat1List[i]*mat2List[i];
		}
		return max;

	}

	static int gcd (int a, int b) {
		int temp;
		while((temp = a%b)!=0) {
			a = b;
			b = temp;
		}
		return b;
	}
}
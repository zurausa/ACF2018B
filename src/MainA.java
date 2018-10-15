import java.io.PrintWriter;

public class MainA {
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
		return (int)Math.round(100-100/N);

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

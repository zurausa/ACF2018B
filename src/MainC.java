import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class MainC {
	static FastScanner sc;
	static PrintWriter out;
	static int N;
	public static void main(String[] args){
		sc = new FastScanner();
		out = new PrintWriter(System.out);
		solve();
//		out.println(solve());
		out.flush();
	}

	static void solve(){
		N = sc.nextInt();
		boolean flg = true;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		sb3.append("X");
		int sb1cnt = 0;
		int sb3cnt = 0;
		for(int i=1;i<=N;i++){
			if(i%3==2||i==N) {
				sb1.append("X");
				sb1cnt ++;
			}
			else sb1.append(".");
			sb2.append(".");
			if(i==N) break;
			if((i-1)%3==0)sb3.append(".");
			else{
				sb3.append("X");
				sb3cnt ++;
			}
		}
		int cnt = 0;
		for(int i=1;i<=N;i++){
			if(i%2==0&&i!=N) out.println(sb2.toString());
			else if(i%2==0&&i==N&&flg) {
				out.println(sb1.toString());
				cnt += sb1cnt;
			}
			else if(i%2==0&&i==N&&!flg){
				out.println(sb3.toString());
				cnt += sb3cnt;
			}
			else if(flg){
				out.println(sb1.toString());
				flg = !flg;
				cnt += sb1cnt;
			}else{
				out.println(sb3.toString());
				flg = !flg;
				cnt += sb3cnt;
			}
		}
		out.println(cnt);
		out.flush();

	}
}

class FastScanner {
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		}else{
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}
	private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	public String next() {
		if (!hasNext()) throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext()) throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while(true){
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			}else if(b == -1 || !isPrintableChar(b)){
				return minus ? -n : n;
			}else{
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
		return (int) nl;
	}
	public double nextDouble() { return Double.parseDouble(next());}
}
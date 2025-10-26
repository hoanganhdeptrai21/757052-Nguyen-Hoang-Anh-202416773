package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
	public static void main(String[] args) {
        int N = 100000;

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < N; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("Time using String +: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (end - start) + " ms");
    }
}

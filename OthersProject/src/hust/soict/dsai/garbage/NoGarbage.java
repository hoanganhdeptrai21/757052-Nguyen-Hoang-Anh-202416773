package hust.soict.dsai.garbage;
import java.io.FileReader;
import java.io.IOException;
public class NoGarbage {
	public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("bigfile.txt");
        int c;
        StringBuffer sb = new StringBuffer();
        while ((c = fr.read()) != -1) {
            sb.append((char) c);
        }
        fr.close();
        System.out.println("Done reading file with StringBuffer");
    }
}

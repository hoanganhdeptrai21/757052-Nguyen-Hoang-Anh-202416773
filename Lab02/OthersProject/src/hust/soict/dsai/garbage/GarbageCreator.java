package hust.soict.dsai.garbage;
import java.io.FileReader;
import java.io.IOException;
public class GarbageCreator {
	public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("bigfile.txt");
        int c;
        String data = "";
        while ((c = fr.read()) != -1) {
            data += (char) c;
        }
        fr.close();
        System.out.println("Done reading file with String +");
    }
}

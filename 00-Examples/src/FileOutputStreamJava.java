import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamJava {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/left.txt");

        String msg = "Hello Java ";
        fos.write(msg.getBytes());

        fos.close();
    }
}

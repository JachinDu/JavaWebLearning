import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/04 15:03
 */

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
}

class Print implements Runnable {
    private PipedReader in;

    public Print(PipedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        int receive = 0;
        try {
            while ((receive = in.read()) != -1) {
                System.out.print((char) receive);
                System.out.print('k');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

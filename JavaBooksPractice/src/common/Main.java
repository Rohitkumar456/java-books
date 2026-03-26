package common;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String uri = "/Users/rohit.kumar";
        File f = new File(uri);
        Thread th = new Thread(new FileSearcher(f, "FileSearcher.java"));
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package company;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;

public class LoadImage implements Runnable {

    interface Observerable {
        void loadComplete();
    }

    private final String urlInmge;
    private final String distDir = "c:\\Users\\ASemeykin\\Desktop\\Test\\";
    private final String distPath;
    private static Integer nImage = 0;

    LoadImage(String url) {
        urlInmge = url;
        distPath = distDir + ++nImage + ".jpg";
    }

    public void run() {

        try {
            URL url = new URL(urlInmge);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(distPath);

            byte[] b = new byte[2048];
            int length;

            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }

            inputStream.close();
            outputStream.close();
            System.out.println("load [" + distPath + "]");
        } catch (Exception e) {

        }
    }


}

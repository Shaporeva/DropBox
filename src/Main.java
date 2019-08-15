import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.android.DropboxParseException;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.Robot;
import java.lang.String;

public class Main {


    public static void main(String[] args) throws AWTException, IOException {

        Thread thread1 = new MyThread();
        thread1.run();

    }
}
/* package whatever; // don't place package name! */


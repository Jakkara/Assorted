import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.*;
import java.nio.file.*;
import java.util.Scanner;

public class DownloadManager {

    public static void download(String url, String file) throws Exception {
        Path path = Paths.get(file);
        URI u = URI.create(url);
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path);
            System.out.println("Download complete.");
        }catch (FileAlreadyExistsException faeE){
            faeE.printStackTrace();
        }
    }

}

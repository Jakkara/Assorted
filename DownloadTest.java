import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.*;
import java.nio.file.*;

public class DownloadTest {
    public static void main(String [] args){
        String url = "http://demo.mapserver.org/cgi-bin/wms?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities";
        String filePath = "./src/wmsTest.xml";
        try {
            download(url,filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void download(String url, String file) throws Exception {
        Path path = Paths.get(file);
        URI u = URI.create(url);
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path);
        }
    }

}

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.*;
import java.nio.file.*;
import java.util.Scanner;

public class DownloadTest {
    public static void main(String [] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Input file URL : ");
        String url = reader.nextLine();
        System.out.println("Input file name : ");
        String filePath = reader.nextLine();
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
        }catch (FileAlreadyExistsException faeE){
            System.out.println("File already exists. Exiting...");
        }
    }

}

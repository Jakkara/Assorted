import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.Scanner;


public class DownloadManager {

    public static void download() throws Exception{
        Scanner reader = new Scanner(System.in);
        System.out.println("Input file URL : ");
        String url = reader.nextLine();
        URI u = URI.create(url);
        System.out.println("Input file name.");
        Path path = Paths.get(reader.nextLine());
        try (InputStream in = u.toURL().openStream()) { //stream from URL
            Files.copy(in, path);       //copy from stream to file path
            System.out.println("\n--***--\nDownload complete.\n--***--\n");
        } catch (FileAlreadyExistsException faeE) {
            System.out.println("A file with that name already exists. Enter a new name : ");
            download(url, reader.nextLine());
        }
    }
    public static void download(String url, String file) throws Exception {
        Path path = Paths.get(file); //file path
        URI u = URI.create(url);
        try (InputStream in = u.toURL().openStream()) { //stream from URL
            Files.copy(in, path);       //copy from stream to file path
            System.out.println("\n--***--\nDownload complete.\n--***--\n");
        } catch (FileAlreadyExistsException faeE) {
            System.out.println("A file with that name already exists. Enter a new name : ");
            Scanner reader = new Scanner(System.in);
            download(url, reader.nextLine());
        }
    }


}

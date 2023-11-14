package pl.hireme.slavshop.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public class FileSystemUtils {

    public static String workDir = System.getProperty("user.dir");

    public static void downloadFileToProductId(Long id, MultipartFile file) throws IOException {
        System.out.println(workDir);
        System.out.println(file.getOriginalFilename());
        file.transferTo(getFileLocation(id));
    }

    public static Path getFileLocation(Long id) {
        return Path.of(workDir + "/" + id);
    }

}

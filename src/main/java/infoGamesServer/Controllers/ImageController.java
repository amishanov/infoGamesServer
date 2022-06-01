package infoGamesServer.Controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class ImageController {

    @GetMapping("/v1/var/images/th2/")
    public ResponseEntity<byte[]> getImage() {
        InputStream in = getClass().getResourceAsStream("/var/images/th2/dc1.png");
        IOUtils.
        return IOUtils.(in);

    }
}

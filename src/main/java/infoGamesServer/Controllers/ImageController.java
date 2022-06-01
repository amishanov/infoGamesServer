package infoGamesServer.Controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ImageController {

    @GetMapping(value = "/v1/var/images/th2/", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/images/th5/mux.png");
        return new ResponseEntity <>(IOUtils.toByteArray(in), HttpStatus.OK);
    }
}

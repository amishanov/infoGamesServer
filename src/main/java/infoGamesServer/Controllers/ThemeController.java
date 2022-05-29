package infoGamesServer.Controllers;

import infoGamesServer.models.Theme;
import infoGamesServer.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThemeController {

    private ThemeService themeService;
    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/v1/themes")
    public ResponseEntity<List<Theme>>getThemes () {
        final List<Theme> themes = themeService.getThemes();
        if (themes != null)
            return new ResponseEntity<>(themes, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/v1/themes")
    public ResponseEntity<?> updateThemes(@RequestHeader("Authorization") String token, @RequestBody List<Theme> themes) {
        if (themeService.updateThemes(themes, token))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

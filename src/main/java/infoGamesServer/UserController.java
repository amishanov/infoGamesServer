package infoGamesServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import infoGamesServer.models.User;
import infoGamesServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<User> read(@RequestBody User token) {
//        System.out.println(token.getAccessToken());
        final User user = userService.read(token.getAccessToken());

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<?> update(@RequestBody User user) {
        final boolean updated = userService.update(user.getAccessToken(), user.getScore(), user.getAccess(), user.getTestsBests(), user.getGamesBests());
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

//    @GetMapping
//    public String test() {
//        return "Test get chi-cha-chuh";
//    }
}

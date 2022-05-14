package infoGamesServer;

import infoGamesServer.models.AuthData;
import infoGamesServer.models.Token;
import infoGamesServer.models.User;
import infoGamesServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/user")
@RestController
public class UserController {

    //TODO Возврат статусов
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/v1/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        Token token = userService.create(user);
        if (token != null)
            return new ResponseEntity<>(token, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @GetMapping(value = "/v1/users")
    public ResponseEntity<User> read(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        final User user = userService.read(token);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/users/login")
    public ResponseEntity<User> readByLogin(@RequestHeader("Authorization") String authStr) {
        String[] sep = authStr.split(":");
        String login = sep[0];
        String password = sep[1];
        final User user = userService.readByLogin(login, password);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/test")
    public ResponseEntity<?> test(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        return null;
    }


    @PutMapping(value = "/v1/users")
    public ResponseEntity<?> update(@RequestBody User user) {
        final boolean updated = userService.update(user.getToken(), user.getScore(), user.getAccess(), user.getTestsBests(), user.getGamesBests());
        return updated
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }
}

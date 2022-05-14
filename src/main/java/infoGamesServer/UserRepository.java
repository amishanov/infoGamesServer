package infoGamesServer;

import infoGamesServer.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User, Integer> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByToken(String token);
}

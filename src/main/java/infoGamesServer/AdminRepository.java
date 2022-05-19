package infoGamesServer;

import infoGamesServer.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, Integer> {
    Admin findAdminByToken(String token);
}

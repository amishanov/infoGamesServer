package infoGamesServer;

import infoGamesServer.models.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, Integer> {
    List<Test> findAll();
}

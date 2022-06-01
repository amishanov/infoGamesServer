package infoGamesServer;

import infoGamesServer.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InfoGamesServerApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(InfoGamesServerApplication.class, args);
		String connection = "mongodb://localhost:27017";
		String dbName = "infoGames";
		String userCollection = "users";
		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);
		String jsonStr = "{\"_id\": 1,\"email\": \"email\", \"login\": \"login\"," +
				" \"password\": \"password\", \"token\": \"token\", \"score\": 0," +
				" \"access\" : [true, false, false, false, false, false]," +
				" \"testsBests\": [null, null, null, null, null, null]," +
				" \"gamesBests\": [0]}";
	}
}

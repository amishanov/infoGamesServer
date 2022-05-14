package infoGamesServer;

import infoGamesServer.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class InfoGamesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoGamesServerApplication.class, args);
		String connection = "mongodb://localhost:27017";
		String dbName = "infoGames";
		String userCollection = "users";

		String jsonStr = "{\"_id\": 1,\"email\": \"email\", \"login\": \"login\"," +
				" \"password\": \"password\", \"token\": \"token\", \"score\": 0," +
				" \"access\" : [true, false, false, false, false, false]," +
				" \"testsBests\": [null, null, null, null, null, null]," +
				" \"gamesBests\": [0]}";
//		boolean[] acc = {true, false, false, false, false, false};
//		Integer[] testsBests = {null, null, null, null, null, null};
//		Integer[] gamesBests = {0};

//		User user = new User(1,"e", "l", "p", "a", 5, acc,
//				testsBests, gamesBests);

//        Document sampleDoc = Document.parse(user.toString());

//		System.out.println(user.toString());
//        col.insertOne(sampleDoc);
	}

//	@Bean
//	CommandLineRunner runner(UserRepository userRepository, MongoTemplate mongoTemplate) {
//		return args -> {
//			Boolean[] acc = {true, false, false, false, false, false};
//			Integer[] testsBests = {null, null, null, null, null, null};
//			Integer[] gamesBests = {0};
//			int _id = 1;
//			String email = "e";
//			String login = "l";
//			String password = "p";
//			String at = "a";
//			Integer score = 5;
//			User user = new User( _id, email, login, password, at, score, acc,
//					testsBests, gamesBests);
//
////			userRepository.findUserByEmail(email).ifPresentOrElse(u -> {
////				System.out.println(u + "already exists");
////			}, () -> {
////				System.out.println("Inserting user " + user);
////				userRepository.insert(user);
////			});
//
//			Query query = new Query();
//			query.addCriteria(Criteria.where("email").is(email).and("login").is(login));
//			List<User> users = mongoTemplate.find(query, User.class);
//
//			if (users.isEmpty()){
//				userRepository.insert(user);
//				System.out.println("Inserting user " + user);
//			}
//			else {
//				System.out.println(user + "already exists");
//			}
//			Boolean[] acc1 = {false, true, true, true, true, false};
//			query = new Query();
//			query.addCriteria(Criteria.where("accessToken").is("a"));
//			user = mongoTemplate.findOne(query, User.class);
//			System.out.println(user.toString());
//			if (user != null) {
//				user.setAccess(acc1);
//				user.setTestsBests(testsBests);
//				user.setGamesBests(gamesBests);
//				mongoTemplate.save(user);
//			} else {
//				System.out.println("check-chirick-AAAA");
//			}
//		};
//	}

}

package infoGamesServer.service;

import infoGamesServer.UserRepository;
import infoGamesServer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MongoTemplate mongoTemplate;

    @Autowired
    public UserServiceImpl(MongoTemplate mongoTemplate, UserRepository userRepository) {
        this.mongoTemplate = mongoTemplate;
        this.userRepository = userRepository;
    }
    @Override
    public String create(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(user.getEmail()).and("login").is(user.getLogin()));
        List<User> users = mongoTemplate.find(query, User.class);
        String token = user.getLogin() + Math.random();
        user.setToken(token);
        if (users.isEmpty()) {
            System.out.println("Inserting user " + user);
            userRepository.insert(user);
            return token;
        } else {
            System.out.println(user + "already exists");
            return null;
        }
    }

    @Override
    public User read(String token) {
        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));
        List<User> users = mongoTemplate.find(query, User.class);
        if (users.isEmpty()) {
            System.out.println("User was not found");
            return null;
        }
        else {
            System.out.println("User was found");
            return users.get(0);
        }
    }

    @Override
    public User readByLogin(String login, String password) {
        Query query = new Query();
        query.addCriteria(Criteria.where("login").is(login).and("password").is(password));
        List<User> users = mongoTemplate.find(query, User.class);
        if (users.isEmpty()) {
            System.out.println("User was not found");
            return null;
        }
        else {
            System.out.println("User was found");
            return users.get(0);
        }
    }

    @Override
    public boolean update(String token, int score, Boolean[] access, Integer[] testsBests, Integer[] gamesBests) {
        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));
        User user = mongoTemplate.findOne(query, User.class);
        System.out.println("Update user: " + user);
        if (user != null) {
            user.setScore(score);
            user.setAccess(access);
            user.setTestsBests(testsBests);
            user.setGamesBests(gamesBests);
            mongoTemplate.save(user);
//            mongoTemplate.update(user);
            System.out.println(user);
            return true;
        }
        return false;
    }
//        userRepository.findUserByAccessToken(token).ifPresentOrElse( user -> {
//            user.setAccess(access);
//            user.setTestsBests(testsBests);
//            user.setGamesBests(gamesBests);
//            userRepository.save(user);
//            res = true;
//            }, () -> {
//            return false;
//                });

}

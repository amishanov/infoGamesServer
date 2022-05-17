package infoGamesServer.service;

import infoGamesServer.UserRepository;
import infoGamesServer.models.Review;
import infoGamesServer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    MongoTemplate mongoTemplate;

    @Autowired
    public ReviewServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public boolean createReview(String token, Review review) {
        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));
        List<User> users = mongoTemplate.find(query, User.class);
        if (users.isEmpty()) {
            System.out.println("Error createReview: Token was not found");
            return false;
        }
        mongoTemplate.insert(review);
        System.out.println("Create review");
        return true;
    }
}

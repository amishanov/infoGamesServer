package infoGamesServer.services;

import infoGamesServer.AdminRepository;
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
    AdminRepository adminRepository;

    @Autowired
    public ReviewServiceImpl(MongoTemplate mongoTemplate, AdminRepository adminRepository) {
        this.mongoTemplate = mongoTemplate;
        this.adminRepository = adminRepository;
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

    @Override
    public List<Review> getReviews(String token) {
        if (adminRepository.findAdminByToken(token) != null) {
            return mongoTemplate.findAll(Review.class);
        }
        return null;
    }
}

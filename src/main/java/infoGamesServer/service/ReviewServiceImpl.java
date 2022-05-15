package infoGamesServer.service;

import infoGamesServer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    MongoTemplate mongoTemplate;

    @Autowired
    public ReviewServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public void createReview(Review review) {
        mongoTemplate.insert(review);
        System.out.println("Create review");
    }
}

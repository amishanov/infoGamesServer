package infoGamesServer.service;

import infoGamesServer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    public boolean createReview(String token, Review review);

    public List<Review> getReviews(String token);
}

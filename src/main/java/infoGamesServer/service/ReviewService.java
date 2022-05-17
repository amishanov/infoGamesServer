package infoGamesServer.service;

import infoGamesServer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


public interface ReviewService {
    public boolean createReview(String token, Review review);
}

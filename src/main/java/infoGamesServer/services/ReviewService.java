package infoGamesServer.services;

import infoGamesServer.models.Review;

import java.util.List;


public interface ReviewService {
    public boolean createReview(String token, Review review);

    public List<Review> getReviews(String token);
}

package infoGamesServer.Controllers;

import infoGamesServer.models.Review;
import infoGamesServer.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/v1/reviews")
    public ResponseEntity<?> createReview(@RequestHeader("Authorization") String token, @RequestBody Review review) {
        boolean res = reviewService.createReview(token, review);
        if (res)
            return new ResponseEntity<> (HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/v1/reviews")
    public ResponseEntity<List<Review>> getReviews(@RequestHeader("Authorization") String token) {
        List<Review> reviews = reviewService.getReviews(token);
        if (reviews == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}

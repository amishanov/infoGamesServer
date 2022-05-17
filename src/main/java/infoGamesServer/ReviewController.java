package infoGamesServer;

import infoGamesServer.models.Review;
import infoGamesServer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
}

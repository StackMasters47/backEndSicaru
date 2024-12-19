package org.stackmasters.sicaru.controller;

import org.stackmasters.sicaru.model.ReviewEntity;
import org.stackmasters.sicaru.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewEntity> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewEntity> getReviewById(@PathVariable Long id) {
        Optional<ReviewEntity> review = reviewService.findById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReviewEntity createReview(@RequestBody ReviewEntity review) {
        return reviewService.save(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewEntity> updateReview(@PathVariable Long id, @RequestBody ReviewEntity reviewDetails) {
        Optional<ReviewEntity> review = reviewService.findById(id);
        if (review.isPresent()) {
            ReviewEntity updatedReview = review.get();
            updatedReview.setProduct(reviewDetails.getProduct());
            updatedReview.setUser(reviewDetails.getUser());
            updatedReview.setReviewDate(reviewDetails.getReviewDate());
            updatedReview.setRating(reviewDetails.getRating());
            updatedReview.setOrder(reviewDetails.getOrder());
            return ResponseEntity.ok(reviewService.save(updatedReview));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (reviewService.findById(id).isPresent()) {
            reviewService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

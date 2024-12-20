package org.stackmasters.sicaru.service;

import org.stackmasters.sicaru.model.ReviewEntity;
import org.stackmasters.sicaru.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewEntity> findAll() {
        return reviewRepository.findAll();
    }

    public Optional<ReviewEntity> findById(Long id) {
        return reviewRepository.findById(id);
    }

    public ReviewEntity save(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}

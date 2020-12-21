package com.kimhs.apis.datamodel.dto;

import com.kimhs.apis.model.Review;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
    private int reviewId;
    private int userId;
    private int rate;
    private String review;

    public ReviewDTO(Review review) {
        this.reviewId = review.getReviewId();
        this.userId = review.getUserId();
        this.rate = review.getRate();
        this.review = review.getReview();
    }

    @Override
    public String toString() {
        return String.format(
                "Review[reviewId=%d, userId=%d, review='%s']",
                this.reviewId, this.userId, this.rate, this.review
        );
    }
}

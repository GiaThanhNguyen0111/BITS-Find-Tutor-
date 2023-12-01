package com.group01.bits.repository;

import com.group01.bits.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT r.* FROM review r WHERE receiver_id = ?1", nativeQuery = true)
    Optional<List<Review>> findAllByReceiverId(Long id);
}

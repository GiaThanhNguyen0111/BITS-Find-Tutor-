package com.group01.bits.repository;

import com.group01.bits.entity.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {

    @Query(value = "SELECT a.* FROM available_time a WHERE a.user_id =?1", nativeQuery = true)
    Optional<List<AvailableTime>> findByUsedIds(Long userId);
}

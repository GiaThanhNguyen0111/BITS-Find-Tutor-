package com.group01.bits.repository;

import com.group01.bits.entity.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
}

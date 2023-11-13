package com.group01.bits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Schedule extends JpaRepository<Schedule, Long> {
}

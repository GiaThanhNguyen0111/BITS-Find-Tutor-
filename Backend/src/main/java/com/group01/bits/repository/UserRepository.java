package com.group01.bits.repository;

import com.group01.bits.entity.Subject;
import com.group01.bits.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.* FROM user AS u WHERE u.email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT u.* FROM user AS u WHERE u.role = \"TUTOR\" AND u.major = ?1", nativeQuery = true)
    Optional<List<User>> findTutorByMajor(String major);

    @Query(value = "SELECT u.* FROM user AS u WHERE u.role = \"TUTOR\" AND u.full_name = ?1", nativeQuery = true)
    Optional<List<User>> findTutorByName(String fullName);

    @Query(value = "SELECT u.* FROM user AS u WHERE u.role = \"TUTOR\"", nativeQuery = true)
    Optional<List<User>> findAllTutor();

}

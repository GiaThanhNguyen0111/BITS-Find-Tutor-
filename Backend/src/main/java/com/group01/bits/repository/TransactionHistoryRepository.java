package com.group01.bits.repository;

import com.group01.bits.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    @Query(value = "SELECT t.* FROM transaction_history t WHERE t.sender_id = ?1 OR t.receiver_id = ?1", nativeQuery = true)
    Optional<List<TransactionHistory>> getTransactionHistoriesByUser(Long id);
}

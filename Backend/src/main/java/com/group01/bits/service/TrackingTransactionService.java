package com.group01.bits.service;

import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.entity.TransactionHistory;

import java.util.List;

public interface TrackingTransactionService {
    List<TransactionHistoryDTO> findTransHisByTutor(Long id);
    TransactionHistoryDTO pay(Double amount, Long fromId, Long toId);
}

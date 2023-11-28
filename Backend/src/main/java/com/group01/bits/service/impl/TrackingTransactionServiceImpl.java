package com.group01.bits.service.impl;

import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.entity.TransactionHistory;
import com.group01.bits.exception.BaseResponseException;
import com.group01.bits.repository.TransactionHistoryRepository;
import com.group01.bits.service.TrackingTransactionService;
import com.group01.bits.template.ResponseStatusCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrackingTransactionServiceImpl implements TrackingTransactionService {

    private final TransactionHistoryRepository transactionHistoryRepository;
    @Override
    public List<TransactionHistoryDTO> findTransHisByTutor(Long id) {
        List<TransactionHistory> transactionHistories = transactionHistoryRepository.getTransactionHistoriesByUser(id).orElseThrow(RuntimeException::new);
        List<TransactionHistoryDTO> transactionHistoryDTOS = new ArrayList<>();
        for (TransactionHistory trans: transactionHistories) {
            TransactionHistoryDTO transactionHistoryDTO = TransactionHistoryDTO.builder()
                    .amount(trans.getAmount())
                    .receiverID(trans.getReceiverID())
                    .createAt(trans.getCreateAt())
                    .build();
            transactionHistoryDTOS.add(transactionHistoryDTO);
        }
        return transactionHistoryDTOS;
    }

    @Transactional
    @Override
    public TransactionHistoryDTO pay(Double amount, Long fromId, Long toId) {
        return null;
    }
}

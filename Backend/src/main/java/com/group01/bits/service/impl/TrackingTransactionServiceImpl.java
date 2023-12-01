package com.group01.bits.service.impl;

import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.entity.TransactionHistory;
import com.group01.bits.entity.User;
import com.group01.bits.exception.BaseResponseException;
import com.group01.bits.repository.TransactionHistoryRepository;
import com.group01.bits.repository.UserRepository;
import com.group01.bits.service.TrackingTransactionService;
import com.group01.bits.template.ResponseStatusCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrackingTransactionServiceImpl implements TrackingTransactionService {

    private final TransactionHistoryRepository transactionHistoryRepository;

    private final UserRepository userRepository;
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
        Optional<User> senderOpt = userRepository.findById(fromId);
        Optional<User> receiverOpt = userRepository.findById(toId);
        TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
        if (senderOpt.isPresent() && receiverOpt.isPresent()) {
            User sender = senderOpt.get();
            User receiver = receiverOpt.get();
            Double senderBalance = sender.getBalance();
            if (senderBalance < amount) {
                throw new BaseResponseException(ResponseStatusCode.builder().code("05").httpCode(HttpStatusCode.valueOf(200)).build());
            }

            sender.setBalance(senderBalance + amount);
            receiver.setBalance(receiver.getBalance() + amount);

            userRepository.save(sender);
            userRepository.save(receiver);

            TransactionHistory transHis = TransactionHistory.builder()
                    .amount(amount)
                    .senderID(fromId)
                    .receiverID(toId)
                    .createAt(new Date())
                    .build();

            transactionHistoryRepository.save(transHis);

            transactionHistoryDTO.setAmount(amount);
            transactionHistoryDTO.setSenderID(fromId);
            transactionHistoryDTO.setReceiverID(toId);
            transactionHistoryDTO.setCreateAt(new Date());
        } else {
            throw new BaseResponseException(ResponseStatusCode.builder().code("06").httpCode(HttpStatusCode.valueOf(200)).build());
        }
        return transactionHistoryDTO;
    }
}

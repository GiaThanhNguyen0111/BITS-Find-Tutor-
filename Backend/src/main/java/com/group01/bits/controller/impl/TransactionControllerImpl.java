package com.group01.bits.controller.impl;

import com.group01.bits.controller.TransactionController;
import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.service.TrackingTransactionService;
import com.group01.bits.template.GeneralResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class TransactionControllerImpl implements TransactionController {

    private final TrackingTransactionService trackingTransactionService;

    @Override
    public GeneralResponse<List<TransactionHistoryDTO>> checkEarning(UserDTO request) {
        List<TransactionHistoryDTO> transactionHistoryDTOS = trackingTransactionService.findTransHisByTutor(request.getUserID());
        return new GeneralResponse<>().success(transactionHistoryDTOS);
    }

    @Override
    public GeneralResponse<TransactionHistoryDTO> pay(TransactionHistoryDTO request) {
        TransactionHistoryDTO transactionHistoryDTO = trackingTransactionService.pay(request.getAmount(), request.getSenderID(), request.getReceiverID());
        return new GeneralResponse<>().success(transactionHistoryDTO);
    }
}

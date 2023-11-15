package com.group01.bits.controller.impl;

import com.group01.bits.controller.TransactionController;
import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public class TransactionControllerImpl implements TransactionController {
    @Override
    public ResponseEntity<TransactionHistoryDTO> checkEarning(UserDTO request) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionHistoryDTO> pay(TransactionHistoryDTO request) {
        return null;
    }
}

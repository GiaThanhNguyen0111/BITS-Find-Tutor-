package com.group01.bits.controller.impl;

import com.group01.bits.controller.TransactionController;
import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.template.GeneralResponse;
public class TransactionControllerImpl implements TransactionController {
    @Override
    public GeneralResponse<TransactionHistoryDTO> checkEarning(UserDTO request) {
        return null;
    }

    @Override
    public GeneralResponse<TransactionHistoryDTO> pay(TransactionHistoryDTO request) {
        return null;
    }
}

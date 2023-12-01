package com.group01.bits.controller;

import com.group01.bits.dto.TransactionHistoryDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.template.GeneralResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// TODO
@RequestMapping("${api.private.path}")
public interface TransactionController {
    @GetMapping("checkEarning")
    GeneralResponse<List<TransactionHistoryDTO>> checkEarning(@RequestBody UserDTO request);

    @PostMapping("pay")
    GeneralResponse<TransactionHistoryDTO> pay(@RequestBody TransactionHistoryDTO request);
}

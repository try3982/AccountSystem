package com.example.account.controller;

import com.example.account.dto.CancelBalance;
import com.example.account.dto.QueryTransactionResponse;
import com.example.account.dto.TransactionDto;
import com.example.account.dto.UseBalance;
import com.example.account.exception.AccountException;
import com.example.account.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 잔액관련 컨트롤러
 * 1. 잔액사용
 * 2. 잔액 사용 취소
 * 3. 거래확인
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("transaction/use")
    public UseBalance.Response useBalance(
            @Valid @RequestBody UseBalance.Request requset
    ){
           try {
               return UseBalance.Response.from(transactionService.useBalance(requset.getUserId(),
                       requset.getAccountNumber(), requset.getAmount())
               );
           } catch(AccountException e) {
               log.error("Failed to use balance. ");

               transactionService.saveFailedUseTransaction(
                       requset.getAccountNumber(),
                       requset.getAmount()
               );

               throw e;
           }
    }

    @PostMapping("transaction/cancel")
    public CancelBalance.Response cancelBalance(
            @Valid @RequestBody CancelBalance.Request request
    ){
        try {
            return CancelBalance.Response.from(
                    transactionService.cancelBalance(String.valueOf(request.getTransactionId()),
                    request.getAccountNumber(), request.getAmount())
            );
        } catch(AccountException e) {
            log.error("Failed to use balance. ");

            transactionService.saveFailedCancelTransaction(
                    request.getAccountNumber(),
                    request.getAmount()
            );

            throw e;
        }


    }
    @GetMapping("/transaction/{transactionId}")
    public QueryTransactionResponse queryTransaction (
            @PathVariable String transactionId) {
        return QueryTransactionResponse.from(transactionService.queryTransactionId(transactionId));

    }




}

package com.example.account.controller;

import com.example.account.dto.UseBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 잔액관련 컨트롤러
 * 1. 잔액사용
 * 2. 잔액 사용 취소
 * 3. 거래확인
 */
@RequiredArgsConstructor
@RestController
public class TransactionController {

    @PostMapping("transaction/use")
    public UseBalance.Response useBalance(
            @Valid @RequestBody UseBalance.Request requset
    ){


    }
}

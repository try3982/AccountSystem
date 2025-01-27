package com.example.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    //요청
    public static class Requset {
        private Long userId;
        private Long initialBalance;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    // 응답
    public static class Response {
        private Long userId;
        private String accountNumber;
        private LocalDateTime registerdAt;
    }
}

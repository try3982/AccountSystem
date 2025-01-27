package com.example.account.dto;

import com.example.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    //요청
    public static class Requset {
        @NotNull
        @Min(1)
        private Long userId;

        @NotNull
        @Min(100)
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

        public static Response from (AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .registerdAt(accountDto.getRegisteredAt())
                    .build();
        }
    }
}

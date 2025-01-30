package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.domain.Transaction;
import com.example.account.dto.TransactionDto;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.repository.TransactionRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.account.type.AccountStatus.IN_USE;
import static com.example.account.type.TransactionResultType.S;
import static com.example.account.type.TransactionType.USE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountUserRepository accountUserRepository;

    @InjectMocks
    private TransactionService transactionService;

//    @Test
//    void successUseBalance() {
//        AccountUser user = AccountUser.builder()
//                .id(12L)
//                .name("Povi").build();
//        Account account = Account.builder()
//                        .accountUser(user)
//                        .accountStatus(IN_USE)
//                        .balance(10000L)
//                        .accountNumber("1000000012").build();
//
//        given(accountUserRepository.findById(anyLong()))
//                .willReturn(Optional.of(user));
//        given(accountRepository.findByAccountNumber(anyString()))
//                .willReturn(Optional.of(account));
//        given(transactionRepository.save(any()))
//                .willReturn(Transaction.builder()
//                        .account(account)
//                        .transactionType(USE)
//                        .transactionResultType(S)
//                        .transactionId("transactionId")
//                        .transactedAt(LocalDateTime.now())
//                        .amount(1000L)
//                        .balanceSnapshot(9000L)
//                        .build());
//
//        ArgumentCaptor<Transaction> captor = ArgumentCaptor.forClass(Transaction.class);
//
//        TransactionDto transactionDto = transactionService.useBalance(1L,"1000000000", "200L");
//
//
//
//        Mockito.verify(transactionRepository, times(1)).save(captor.capture());
//        assertEquals(S, transactionDto.getTransactionResultType());
//        assertEquals(USE, transactionDto.getTransactionType());
//        assertEquals(9000L, transactionDto.getBalanceSnapshot());
//        assertEquals(1000L, transactionDto.getAmount());
//
//
//
//    }


}
package com.ajay.mong.service;

import com.ajay.mong.entity.Account;
import com.ajay.mong.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

   private final AccountRepository accountRepository;
    public Mono<Account> saveAccount(Account account){
        if (account.getId()==null) {
            account.setId(String.valueOf(UUID.randomUUID()));
        }

        return   accountRepository.save(account);
    }

    public Mono<Account> getById(String id){
        return accountRepository.findAccountById(id);
    }

    public Flux<Account> getByOwner(String owner){
        return accountRepository.findAccountByOwner(owner);
    }

    public Flux<Account> getAll(){
        return accountRepository.findAll();
    }

    public Mono<Void> deleteById(String id){
        return accountRepository.deleteById(id);
    }

}


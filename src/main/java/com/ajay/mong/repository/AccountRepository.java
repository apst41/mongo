package com.ajay.mong.repository;

import com.ajay.mong.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    Flux<Account> findAllByValue(String value);
    Mono<Account> findFirstByOwner(String owner);
    Mono<Account> findAccountById(String id);

    Flux<Account> findAccountByOwner(String findAccountByOwner);
}

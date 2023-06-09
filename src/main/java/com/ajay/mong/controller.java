package com.ajay.mong;

import com.ajay.mong.entity.Account;
import com.ajay.mong.service.AccountService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/mong/")
@AllArgsConstructor
@Slf4j
public class controller {
    private final AccountService accountService;
    private final Gson gson;

    @PostMapping()
    public Mono<Account> saveAccount(@RequestBody Account account){
        log.info("save details \n {}",gson.toJson(account));
        return accountService.saveAccount(account);
    }

    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable String id ){
        return accountService.getById(id);
    }

    @GetMapping("/owner/{owner}")
    public Flux<Account> getByOwner(@PathVariable String owner){
        return accountService.getByOwner(owner);
    }
}

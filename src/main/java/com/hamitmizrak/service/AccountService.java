package com.hamitmizrak.service;


import com.hamitmizrak.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hamitmizrak.entity.AccountCassandra;
import org.springframework.util.Assert;

import java.util.List;

//Lombok
@RequiredArgsConstructor

//unutma: bu service başka serviside çağırabilir.
@Service
// @Component: web classları için
// @Repository: veri tabanı işlemlerinden
public class AccountService {

    //inject
    private final AccountRepository accountRepository;

    //FIND
    public AccountCassandra get(String id){
        //Eğer ilgili id varsa dönder yoksa IllegalArgumentExce
        return accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
    }

    //LIST
    public List<AccountCassandra> findAll() {
        return  accountRepository.findAll();
    }

    //SAVE
    public AccountCassandra save(AccountCassandra account){
        return accountRepository.save(account);
    }

    //UPDATE
    public AccountCassandra update(String id, AccountCassandra account){
        Assert.isNull(id,"id not null");
        return new AccountCassandra("test-id");
    }

    //DELETE
    //sunucuyu yormamak için nesne gödnermemize gerek yoktur.
    public void delete(String id){
    }

}

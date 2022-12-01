package com.hamitmizrak.api;

import com.hamitmizrak.entity.AccountCassandra;
import com.hamitmizrak.service.AccountService;
import lombok.RequiredArgsConstructor;


// @GetMapping  @PostMapping  @DeleteMapping v.s olduğu için hepsini çağırdı.
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Lombok
@RequiredArgsConstructor

//Spring tarafınnan oluşturlması için Spring annotation olması gerekiyor.
// Bu annotation ile ramde yaşamını sürdürür.
//Dış dünyaya açılacaktır.
@RestController
@RequestMapping("/account")
public class AccountApi {

    //injection
    private final AccountService accountService;

    //LIST
    //http://localhost:8080/account
    //Eğer 1 tane name kullanılmışsa @PathVariable name yazmana gerek yoktur
    @GetMapping()
    public ResponseEntity<List<AccountCassandra> > getAllList() {
        return ResponseEntity.ok(accountService.findAll());
    }

    //FIND
    //http://localhost:8080/account/1
    //Eğer 1 tane name kullanılmışsa @PathVariable name yazmana gerek yoktur
    @GetMapping("/{id}")
    public ResponseEntity<AccountCassandra> get(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    //SAVE
    //http://localhost:8080/account
    @PostMapping
    public ResponseEntity<AccountCassandra> save(@RequestBody AccountCassandra account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    //UPDATE
    //http://localhost:8080/account
    @PutMapping
    public ResponseEntity<AccountCassandra> update(@PathVariable("id") String id, @RequestBody AccountCassandra account ) {
        return ResponseEntity.ok(accountService.update(id,account));
    }

    //DELETE
    //sunucuyu yormamak için nesne gödnermemize gerek yoktur.
    //http://localhost:8080/account/1
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
    }

}

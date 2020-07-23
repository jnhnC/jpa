package com.example.jpa.account;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<List<Account>> getAllAccount(){
        List<Account> accountList = accountService.findAll();
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }
    @GetMapping("/login/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id){
        Account account = accountService.findById(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PutMapping("/login/{id}")
    public ResponseEntity<Account> updateUser(@RequestBody Account user, @PathVariable("id") Long id) { // getUser(id) return
        accountService.updateById(id, user);
        System.out.println(user.toString());
        return new ResponseEntity<Account>(user, HttpStatus.OK);
    }

    @DeleteMapping("login/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") Long id) {
        accountService.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }

}

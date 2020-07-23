package com.example.jpa.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public void findByUsername() {
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    public void updateById(Long id, Account user) {
        Optional<Account> e = accountRepository.findById(id);
        if (e.isPresent()) {
            e.get().setUsername(user.getUsername());
            e.get().setPassword(user.getPassword());
            accountRepository.save(user);
        }

    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}

package net.organization.banking.service.impl;

import net.organization.banking.dto.AccountDto;
import net.organization.banking.exception.AccountException;
import net.organization.banking.mapper.AccountMapper;
import net.organization.banking.model.Account;
import net.organization.banking.repository.AccountRepository;
import net.organization.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saved =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saved);
    }

    @Override
    public AccountDto getAccountById(Long id) {
      Account account= accountRepository
              .findById(id)
              .orElseThrow(() -> new AccountException("Account does not exist."));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist."));
        double total = account.getBalance()+amount;
        account.setBalance(total);
       Account saved = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(saved);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account= accountRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist."));
        if (account.getBalance() < amount){
            throw new AccountException("Insufficient amount.");
        }
        double total = account.getBalance()- amount;
        account.setBalance(total);
        Account saved = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saved);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account> allAccounts = accountRepository.findAll();
      return allAccounts.stream().map((account )->AccountMapper.mapToAccountDto(account))
               .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist."));

        accountRepository.deleteById(id);
    }
}

package net.organization.banking.mapper;

import net.organization.banking.dto.AccountDto;
import net.organization.banking.model.Account;


public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
        accountDto.getId(),
        accountDto.getAccountHolderName(),
        accountDto.getBalance()
                );

    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}

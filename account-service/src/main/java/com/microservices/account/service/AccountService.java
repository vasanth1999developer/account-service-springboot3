package com.microservices.account.service;

import java.util.List;

import com.microservices.account.model.AccountBO;

public interface AccountService {

	AccountBO createAccount(AccountBO bo);

	List<AccountBO> getAllAccount();

	AccountBO updateAccount(AccountBO bo);

	AccountBO getAccountId(int id);

	AccountBO deletAccount(AccountBO bo);

}

package com.microservices.account.dao;

import java.util.List;

import com.microservices.account.entity.AccountVO;

public interface AccountDAO {

	AccountVO createAccount(AccountVO vo);

	List<AccountVO> getAllAccount();

	AccountVO updateAccount(AccountVO vo);

	AccountVO getAccountById(int id);

	AccountVO deleteaccount(AccountVO vo);

}

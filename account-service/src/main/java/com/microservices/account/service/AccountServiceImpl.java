package com.microservices.account.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.account.dao.AccountDAO;
import com.microservices.account.entity.AccountVO;
import com.microservices.account.model.AccountBO;



@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDAO dao;

	@Override
	public AccountBO createAccount(AccountBO bo) {
	AccountVO vo=new AccountVO();
	try {
		BeanUtils.copyProperties(bo, vo);
		vo.setIsdelete(false);
		vo=dao.createAccount(vo);
		if(null!=vo) {
			bo.setAccountId(vo.getAccountId());
			return bo;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
		return null;
	}

	@Override
	public List<AccountBO> getAllAccount() {
		List<AccountVO> volist=new ArrayList<>();
		List<AccountBO> bolist=new ArrayList<>();
		try {
			volist=dao.getAllAccount();
			if(null!=volist)
			{
				for(AccountVO vo:volist) {
					AccountBO bo=new AccountBO();
			
					  bo.setAccountId(vo.getAccountId());
					  bo.setAccountName(vo.getAccountName());
					  bo.setAccountOwner(vo.getAccountOwner());
					 bo.setAnnualRevenue(vo.getAnnualRevenue());
					 bo.setCity(vo.getCity());
					 bo.setContactNumber(vo.getContactNumber());
					 bo.setCountry(vo.getCountry());
					 bo.setDescription(vo.getDescription());
					 bo.setEmail(vo.getEmail());
					 bo.setIndustry(vo.getIndustry());
					 bo.setNoOfEmploye(vo.getNoOfEmploye());
					 bo.setParentAccount(vo.getParentAccount());
					 bo.setPincode(vo.getPincode());
					 bo.setSalutation(vo.getSalutation());
					 bo.setState(vo.getState());
					 bo.setStreet(vo.getStreet());
					 
					bolist.add(bo);
					
				
				}
				return bolist;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccountBO updateAccount(AccountBO bo) {
		AccountVO vo=new AccountVO();
		try {
			vo.setAccountId(bo.getAccountId());
			BeanUtils.copyProperties(bo, vo);
			vo=dao.updateAccount(vo);
			if(null!=vo) {
				bo.setAccountId(vo.getAccountId());
				return bo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountBO getAccountId(int id) {
		AccountVO vo=new AccountVO();
		try {
			vo=dao.getAccountById(id);
			if(null!=vo) {
				AccountBO bo=new AccountBO();
				BeanUtils.copyProperties(vo, bo);
				return bo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public AccountBO deletAccount(AccountBO bo) {
	try {
		AccountVO vo=new AccountVO();
		vo.setAccountId(bo.getAccountId());
		vo.setIsdelete(true);
		vo=dao.deleteaccount(vo);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
	}

}

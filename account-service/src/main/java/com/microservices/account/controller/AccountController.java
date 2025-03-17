package com.microservices.account.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.account.model.AccountBO;
import com.microservices.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/create-account")
	public ResponseEntity<?> createAccount(@RequestBody AccountBO bo,HttpServletRequest request){
		try {
			if(null!=request.getHeader("id")) {
				String id=request.getHeader("id");
				long number=Long.parseLong(id);
				bo.setCreatedBy(number);
			}
			bo=service.createAccount(bo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(bo);
		
	}
	
	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getAllAccount(){
		List<AccountBO> accountlist=new ArrayList<>();
		try {
			accountlist=service.getAllAccount();
			if(null==accountlist||accountlist.size()==0||accountlist.isEmpty()) {
				return new ResponseEntity<List<AccountBO>>(accountlist,HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<List<AccountBO>>(accountlist,HttpStatus.OK);
		
	}
	
	@PutMapping("/update-account/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody AccountBO bo,@PathVariable int id,HttpServletRequest request){
		try {
			if(null!=request.getHeader("id")) {
	            String id1=request.getHeader("id");
	             long number = Long.parseLong(id1);
	             bo.setModifiedBy(number);
	           }
			AccountBO acc=new AccountBO();
			acc=service.getAccountId(id);
			bo.setAccountId(id);
			if(0!=bo.getAccountId()) {
			bo=service.updateAccount(bo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(bo);
		
	}
	
	@GetMapping("/get-account/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable int id){
		AccountBO bo=new AccountBO();
		try {
			bo.setAccountId(id);
			bo=service.getAccountId(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(bo);
		
	}
	
	@DeleteMapping("/delete-account/{id}")
	public ResponseEntity<?> deletAccountById(@PathVariable int id){
		/* boolean status=false; */
		AccountBO bo=new AccountBO();
		try {
			
			bo.setAccountId(id);
			bo=service.deletAccount(bo);
			//if(null!=bo) {
//				return ResponseEntity.ok(true);
			//}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(bo);
		
	}

}

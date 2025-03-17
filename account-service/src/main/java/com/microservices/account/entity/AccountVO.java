package com.microservices.account.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "account")
@Data
public class AccountVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3688712325438985305L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String accountOwner;
	private String accountName;
	private String parentAccount;
	private String salutation;
	private String annualRevenue;
	private String email;
	private long contactNumber;
	 private int employeeId;
	private String assigntedTo;
	
	private String type;
	private String industry;
	private long noOfEmploye;
	private String street;
	private String city;
	private String state;
	private String country;
	private long pincode;
	private String description;
	private boolean isdelete;
}

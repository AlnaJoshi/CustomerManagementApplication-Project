package com.cust_app.model.persistence;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer_info_table")
public class Customer  {
	@Id
	@GeneratedValue
	private int custId;
	
	@NotEmpty
	private String custName;
	
	@NotEmpty
	@Email
	private String custEmail;
	
	@NotEmpty
	private String custPhone;
	
	@NotEmpty
	private String product;
	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPhone="
				+ custPhone + ", product=" + product + "]";
	}

	public Customer(String custName, String custEmail, String custPhone, String product) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPhone = custPhone;
		this.product = product;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

}

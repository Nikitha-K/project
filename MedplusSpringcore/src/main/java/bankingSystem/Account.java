package bankingSystem;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component

public class Account {
	
	private  int accno;
	private String custname;
	private Address address;
	private int balance;
	private Date datecreation;

	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {


		this.datecreation = datecreation;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", custname=" + custname + ", address=" + address + ", balance=" + balance
				+ ", datecreation=" + datecreation + "]";
	}
	

}

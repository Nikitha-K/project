package bankingSystem;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component

public class Transaction {
private	int accno;
private java.sql.Date date;
private String type;
private String description;
private int amount;
private int balance;
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}

public java.sql.Date getDate() {
	return date;
}
public void setDate(java.sql.Date date) {
	
	this.date = date;
}
@Override
public String toString() {
	return "Transaction [accno=" + accno + ", date=" + date + ", type=" + type + ", description=" + description
			+ ", amount=" + amount + ", balance=" + balance + "]";
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}


	

}

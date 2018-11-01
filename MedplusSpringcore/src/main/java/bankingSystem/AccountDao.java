package bankingSystem;

import java.util.List;

public interface AccountDao {
	int createAccount();
	int deposit(int accno,int amount);
	int withdraw(int accno,int amount);

	Account getAccountdetails(int empcode);
	List miniStatement(int accno);
	

}

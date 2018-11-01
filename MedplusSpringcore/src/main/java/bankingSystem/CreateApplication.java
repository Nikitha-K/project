package bankingSystem;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateApplication {
	static int sequence =1000;
	
	public static void main(String[] args) {
	ApplicationContext ap= 	new ClassPathXmlApplicationContext("Annotations.xml");
	Account acc= ap.getBean("account",Account.class);
	Address add=ap.getBean("address",Address.class);
	AccountDao ad = ap.getBean("accountDaoImpl",AccountDaoImpl.class);
	Scanner sc = new Scanner(System.in);
	acc.setAccno(sequence);
	sequence =sequence+1;

	System.out.println("enter acc no");
	acc.setCustname(sc.next());
	System.out.println("enter acc bal");
	acc.setBalance(sc.nextInt());	
	acc.setDatecreation(new Date());
	System.out.println("enter city");
	add.setCity(sc.next());
	System.out.println("enter street");
	add.setStreet(sc.next());
	acc.setAddress(add);
	int a=ad.createAccount();
	if(a>1) {
		System.out.println("acc created ");
	}

		
		
	}

}

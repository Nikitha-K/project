package bankingSystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component

public class DepositApp {
	
	public static void main(String [] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("Annotations.xml");
		AccountDaoImpl ad=ap.getBean("accountDaoImpl",AccountDaoImpl.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter accno");
		int accno=sc.nextInt();
		System.out.println("enter amount");

		int amount=sc.nextInt();
		ad.deposit(accno, amount);
		
		
	}

}

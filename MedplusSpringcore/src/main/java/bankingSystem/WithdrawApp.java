package bankingSystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithdrawApp {
	public static void main(String [] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("Annotations.xml");
		AccountDaoImpl ad=ap.getBean("accountDaoImpl",AccountDaoImpl.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter accno");
		int accno=sc.nextInt();
		System.out.println("enter amount");

		int amount=sc.nextInt();
		ad.withdraw(accno, amount);
List<Transaction> list=ad.miniStatement(333);
System.out.println(list);
}
}
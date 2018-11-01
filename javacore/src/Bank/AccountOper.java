package Bank;

import java.util.ArrayList;

public class AccountOper {
int acc=100;
boolean flag;
int minbal= 1000;
AccountDetails ad;
ArrayList<AccountDetails> list = new ArrayList<>();
public int create() {
	list.add(new AccountDetails(acc,minbal));
	
	System.out.println("your acc no is "+acc);
	System.out.println("bal is"+minbal);
	acc=acc+1;
	return acc-1;
	
}
public void createaccount() {
	list.add(new AccountDetails(111,1000));
	list.add(new AccountDetails(211,1000));
	list.add(new AccountDetails(311,1000));
	list.add(new AccountDetails(411,1000));
	
}



public boolean check(int acc) {
	  for (AccountDetails ac :list) {
      	if(ac.getAccno()==acc) {
      		ad=ac;
      		
      		 return true;
      	}
      
      }
    
	return false;
}
public int bal() {
	return ad.getBal();
}


public void withdraw(int acc,int amt) {
	if(check(acc)) {
		if(amt>ad.getBal()) {
			try {
			throw new MyException1();
			}catch(MyException1 e) {
				System.out.println(e);
			}
		}
		else {
			ad.setBal(ad.getBal()-amt);
			System.out.println("updated bal is "+ad.getBal());
			
		}
	
		
	}
	else {try {
		throw new MyException();
		}catch(MyException e) {
			System.out.println(e);
		}
	
		
	}
	
}
public void deposit(int acc,int bal) {
	if(check(acc)) {
			ad.setBal(ad.getBal()+bal);
			System.out.println("updated bal is "+ad.getBal());
			
		}
	
		
	
	else {try {
		throw new MyException();
		}catch(MyException e) {
			System.out.println(e);
		}
	
		
	}
	
	
}
public void displayList() {
	System.out.println(list);
}

}

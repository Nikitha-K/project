package Bank;	

import java.util.List;import java.util.Scanner;

public class MainApplication extends AccountOper {
	public static void main(String[] args) {
		
		
	MainApplication ma = new MainApplication();
		Scanner sc = new Scanner(System.in);
		ma.createaccount();
      
        System.out.println("enter the acc no");
   int accnum=sc.nextInt();
 boolean b= true;
	   
   
while(b){
		
      
        	System.out.println("enter  d for deposit w for withdraw c for check bal a for account creation l for acclist "); 
        	
        	switch(sc.next().charAt(0)) {
        		case 'd':
        		
        			System.out.println("enter the amt ");
        	ma.deposit(accnum,sc.nextInt());
        	
        	break;
        		case 'w':
        			System.out.println("enter the amt");
        		ma.withdraw(accnum, sc.nextInt());
        		break;
        		case 'c'  :
        			System.out.println(ma.bal());
        			break;
        		case'a':
        		accnum=	ma.create();
        			
        			break;
        		case'l':	
        			ma.displayList();
        			break;
        			
        			default:
        				System.out.println("wrong);
        				b=false;
        			
        	
        	}
        	
        	
        	
}

        	
   }
        }
        
      
	



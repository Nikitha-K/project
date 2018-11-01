package javacore;

import java.util.Scanner;

public class BerthReservation extends Thread {
	static int  available =10;
	int  requested;
	
	public  void run() {
		System.out.println("welcome"+Thread.currentThread().getName());
		
		System.out.println("total availableis"+available);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the required tickets do you need" );
		requested=sc.nextInt();
		if (available ==0) {
			System.out.println("sorry ");
			
		}
		else {
			if(requested <=available) {
				available = available -requested;
				System.out.println("sucess");
				requested=0;
			}
			else
				System.out.println("ony "+available+" are available");
		}
		
	}
	
	

}

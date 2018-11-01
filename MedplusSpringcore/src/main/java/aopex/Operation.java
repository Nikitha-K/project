package aopex;

import org.springframework.stereotype.Component;

@Component
public class Operation {
public void msg() {
	System.out.println("msg method invoked");
}
public int n() {
System.out.println("n method invoked");
return 1;
}
public int p() {
	System.out.println("p method invoked");
	return 2;
}
}

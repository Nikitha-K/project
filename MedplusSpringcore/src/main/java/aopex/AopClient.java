package aopex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopClient {
public static void main(String[] args) {
	ApplicationContext ctx= new ClassPathXmlApplicationContext("Annotations.xml");
	Operation op=ctx.getBean("operation",Operation.class);
	op.msg();
	op.n();
	op.p();
}
}

package annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("Annotations.xml");
		
//        Student std = ctx.getBean("student",Student.class);
//        
//        System.out.println(std);
		Car car =ctx.getBean("car",Car.class);
		car.moving("bedrock");
        
	}

}

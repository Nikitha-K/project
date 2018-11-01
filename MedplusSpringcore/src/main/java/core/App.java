package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext ctx= new ClassPathXmlApplicationContext("Context.xml");
        Employee emp =ctx.getBean("emp",Employee.class);
        Employee emp1 =ctx.getBean("emp",Employee.class);
        emp.setName("akhil123");
        System.out.println(emp.getCode()+" "+emp.getName());
        System.out.println(emp1.getCode()+" "+emp1.getName());        
        System.out.println(emp.getAddress());
    }
}

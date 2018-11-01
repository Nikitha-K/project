package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"sample"})
public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class);
	
}

}
//http://localhost:1234/springbootmvc/welcome
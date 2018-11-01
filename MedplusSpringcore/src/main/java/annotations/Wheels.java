package annotations;

import org.springframework.stereotype.Component;

@Component
public interface Wheels {
void rotate(String str);
default void material(String str) {
	System.out.println("material used is rubber");
}
	
}

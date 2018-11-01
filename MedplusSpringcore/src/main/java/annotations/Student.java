package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value(value = "111")
	private int regno;
@Value	(value="akhil")
private String name;
@Autowired
private Marks marks;

	
	public Marks getMarks() {
	return marks;
}
public void setMarks(Marks marks) {
	this.marks = marks;
}
	
	
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [regno=" + regno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}

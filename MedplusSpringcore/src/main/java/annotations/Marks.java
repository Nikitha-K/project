package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Marks {
	@Value("200")
	private int total;
	@Value("s")
	private char garde;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Marks [total=" + total + ", garde=" + garde + "]";
	}
	public char getGarde() {
		return garde;
	}
	public void setGarde(char garde) {
		this.garde = garde;
	}

}

package Bank;

public class AccountDetails {
 int accno;
int bal;
public AccountDetails(int accno, int bal) {
	
	this.accno = accno;
	this.bal = bal;
}
public int getAccno() {
	return accno;
}
@Override
public String toString() {
	return "AccountDetails [accno=" + accno + ", bal=" + bal + "]";
}
public void setAccno(int accno) {
	this.accno = accno;
}
public int getBal() {
	return bal;
}
public void setBal(int bal) {
	this.bal = bal;
}
	
}
	
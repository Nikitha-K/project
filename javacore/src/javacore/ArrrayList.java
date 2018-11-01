package javacore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
System.out.println(list);
list.remove(new Integer(2));

System.out.println(list);
List<employee> list1= new ArrayList<>();

list1.add(new employee("aa",111,2000));
list1.add(new employee("ra",111,2000));
list1.add(new employee("ca",111,2000));

	
list1.add(new employee("aa",111,2000));

Comparator<employee> cm = new Comparator<employee>() {

	@Override
	public int compare(employee o1, employee o2) {
		return o1.name.compareTo(o2.name);
		
		
	}

	
	
};
list1.sort(cm);

System.out.println(list1);
	}
}


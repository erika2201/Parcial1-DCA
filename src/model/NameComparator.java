package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Dog> {
	
	public int compare(Dog o1, Dog o2) {
		return o1.getName().compareTo(o2.getName()) ;
	}

}

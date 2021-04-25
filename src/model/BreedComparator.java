package model;

import java.util.Comparator;

public class BreedComparator implements Comparator<Dog> {
	
	public int compare(Dog o1, Dog o2) {
		return o1.getBreed().compareTo(o2.getBreed()) ;
	}

}

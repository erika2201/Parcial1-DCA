package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] infoTXT1;
	private String [] infoTXT2;
	
	private LinkedList<Dog> dogList;
	
	private String [] toID;
	private String [] toName;
	private String [] toBreed;
	private String [] toBirth;
	private String [] toAge;
	
	NameComparator NameComp;
	BreedComparator BreedComp;
	BirthComparator BirthComp;
	AgeComparator AgeComp;
	
	public Logic(PApplet app){
		this.app=app;	
		
		//load info about TXTs
		infoTXT1= app.loadStrings("../data/TXT1.txt");
		infoTXT2= app.loadStrings("../data/TXT2.txt");
		
		//initialization LinkedList
		dogList = new LinkedList<Dog>();
		
		for (int i = 0; i < infoTXT1.length; i++) {
			
			String[] dogAttributes1 = infoTXT1[i].split(" ");
			
			int id = Integer.parseInt(dogAttributes1[0]);
			String name = dogAttributes1[1];
			for (int j = 0; j < infoTXT2.length; j++) {	
				
				String[] dogAttributes2 = infoTXT2[j].split(" ");
				if(id == Integer.parseInt(dogAttributes2[0])) {
				
					String breed = dogAttributes2[1];
					String birth = dogAttributes2[2];
					String[] birthday= birth.split("-");
					String dogBirthday= birthday[2] +"-"+ birthday[1] +"-"+ birthday[0] ;
	    LocalDate dogBirth = LocalDate.parse(dogBirthday); //localDate is other (better) way to show date than before c:
	    LocalDate date = LocalDate.now();

	    int age = toCalAge(dogBirth,date); //try to calculate age of dogs, call the method to calculate age
					dogList.add(new Dog(id, name, age, breed,app));
				}
				
			}
		}
		
		toID = new String[5];
		toName = new String[5];
		toBreed = new String[5];
		toBirth = new String[5];
		toAge = new String[5];
		
		NameComp = new NameComparator();
		BreedComp = new BreedComparator();
		BirthComp = new BirthComparator();
		AgeComp = new AgeComparator();
		
		infoTXT1 = PApplet.sort(infoTXT1);
		infoTXT2 = PApplet.sort(infoTXT2);

	}
	
	 public  int toCalAge(LocalDate birthDate, LocalDate currentDate) {
	        if ((birthDate != null) && (currentDate != null)) {
	            return Period.between(birthDate, currentDate).getYears();
	        } else {
	            return 0;
	        }
	    }
	
	public void sortList(char c) {
		switch (c) {
		case 'i':
			
			break;
		
		case 'n':
		
			Collections.sort(dogList, NameComp);
		
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getId());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				name = name.toLowerCase();
				String breed = dogList.get(i).getBreed();
				breed= breed.toLowerCase();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String birth = format.format (dogList.get(i).getDate());

				String line = ID + " " + name + " " + breed + " " + age + " " + birth;
				toName[i] = line;
			}
			this.app.saveStrings("toName.txt", toName);
			break;
		
		case 'e':
			Collections.sort(dogList, AgeComp);
	
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getId());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				name = name.toLowerCase();
				String race = dogList.get(i).getBreed();
				race= race.toLowerCase();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				toAge[i] = line;
			}
			this.app.saveStrings("byAge.txt", toAge);
			break;
		
		case 'r':
			
			break;
		
		case 'f':
			
			break;

		default:
			break;
		}
	}
	
	public LinkedList<Dog> getDogList() {
		return dogList;
	}
	
	public void setDogList(LinkedList<Dog> dogList) {
		this.dogList = dogList;
	}
}

package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public Logic(PApplet app){
		this.app=app;	
		
		//load info about TXTs
		infoTXT1= app.loadStrings("../data/TXT1.txt");
		infoTXT2= app.loadStrings("../data/TXT2.txt");
		
		//initialization LinkedList
		dogList = new LinkedList<Dog>();
		
		for (int i = 0; i < infoTXT1.length; i++) {
			String[] lineString = infoTXT1[i].split(" ");
			
			int id = Integer.parseInt(lineString[0]);
			String name = lineString[1];
			int age = Integer.parseInt(lineString[2]);

			String[] lineString2 = infoTXT2[i].split(" ");
			String breed = lineString2[1];
		
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
			
			try {date = format.parse(lineString2[2]);
			} catch (ParseException ex) {
				System.out.println(ex);
			}					
			addElementList(new Dog(app, age, breed, age, breed, date));// the element is added to the list
		}
		
		toID = new String[5];
		toName = new String[5];
		toBreed = new String[5];
		toBirth = new String[5];
		toAge = new String[5];
	}
	

	public void addElementList(Dog dog) {
		dogList.add(dog); //to add the dog
	}
	
	public void sortList() {
		switch (app.key) {
		case 'i':
			
			break;
		
		case 'n':
			
			break;
		
		case 'e':
			
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

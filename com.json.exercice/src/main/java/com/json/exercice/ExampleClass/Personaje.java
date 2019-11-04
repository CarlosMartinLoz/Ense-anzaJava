package com.json.exercice.ExampleClass;

public class Personaje {
	
    private String name;
    private int age;
    private boolean bites;
    
	public Personaje(String name, int age, boolean bites) {
		super();
		this.name = name;
		this.age = age;
		this.bites = bites;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isBites() {
		return bites;
	}
	public void setBites(boolean bites) {
		this.bites = bites;
	}

}

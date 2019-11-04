package com.json.exercice.ExampleClass;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jsonb json = JsonbBuilder.create();
		Personaje personaje = new Personaje("sdsd",2323,true);
		String sds= json.toJson(personaje);
		System.out.println(sds);
	}

}

package org.com.cay.test;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.com.cay.entity.Car;
import org.com.cay.entity.PersonForGson;
import org.com.cay.entity.PersonForJson;
import org.junit.Test;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {

	@Test
	public void test() {
		gsonReadFromFile();
	}

	private void gsonFromBean() {
		PersonForJson person = new PersonForJson();
		person.setName("老王");
		person.setBirthday("1990-01-01");
		person.setSingle(false);
		person.setMajor(new String[]{"C++","Java","PHP"});
		person.setCar(new Car("白色","法拉利",3500000));
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(person));
	}
	
	private void prettyGson(){
		PersonForJson person = new PersonForJson();
		person.setName("老王");
		person.setBirthday("1990-01-01");
		person.setSingle(false);
		person.setMajor(new String[]{"C++","Java","PHP"});
		person.setCar(new Car("白色","法拉利",3500000));
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		
		//将某个字段的名字换成大小
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			
			public String translateName(Field arg0) {
				// TODO Auto-generated method stub
				if(arg0.getName().equals("name")){
					return "NAME";
				}
				return arg0.getName();
			}
		});
		Gson gson = gsonBuilder.create();
		System.out.println(gson.toJson(person));
	}
	
	private void gsonReadFromFile(){
		File file = new File(TestJson.class.getClassLoader().getResource("person.json").getFile());
		String content = null;
		try {
			content = FileUtils.readFileToString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置日期格式
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		PersonForGson person = gson.fromJson(content, PersonForGson.class);
		System.out.println(person.getBirthday());
		System.out.println(person.getMajor());
		System.out.println(person.getMajor().getClass().getName());
	}

}

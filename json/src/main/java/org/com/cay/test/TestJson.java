package org.com.cay.test;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.com.cay.entity.Car;
import org.com.cay.entity.PersonForJson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class TestJson {

	@Test
	public void test() {
		jsonFromMap();
	}

	private void jsonTest1() {
		JSONObject person = new JSONObject();
		person.put("name", "老王");
		person.put("birthday", "1990-01-01");
		person.put("isSingle", false);
		person.put("major", new String[]{"C++","Java","PHP"});
		person.put("car", new Car("白色","法拉利",3500000));
		
		System.out.println(person.toString());
	}
	
	private void jsonFromBean(){
		PersonForJson person = new PersonForJson();
		person.setName("老王");
		person.setBirthday("1990-01-01");
		person.setSingle(false);
		person.setMajor(new String[]{"C++","Java","PHP"});
		person.setCar(new Car("白色","法拉利",3500000));
		System.out.println(new JSONObject(person).toString());
	}
	
	private void jsonFromMap(){
		Map<String, Object> person = new HashMap<String, Object>();
		person.put("name", "老王");
		person.put("birthday", "1990-01-01");
		person.put("isSingle", false);
		person.put("major", new String[]{"C++","Java","PHP"});
		person.put("car", new Car("白色","法拉利",3500000));
		System.out.println(new JSONObject(person).toString());
	}
	
	private void jsonReadFromFile(){
		File file = new File(TestJson.class.getClassLoader().getResource("person.json").getFile());
		String content = null;
		try {
			content = FileUtils.readFileToString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = new JSONObject(content);
		
		if(!json.isNull("id")){
			System.out.println("id: " + json.getString("id"));
		}
		
		System.out.println("name: " + json.getString("name"));
		System.out.println("birthday: " + json.getString("birthday"));
		System.out.println("isSingle: " + json.getBoolean("isSingle"));
		JSONArray majorArray = json.getJSONArray("major");
		for(int i = 0;i < majorArray.length();++i){
			System.out.println("major " + i + ": " + majorArray.get(i));
		}
		
		JSONObject carObject = json.getJSONObject("car");
		System.out.println("color: " + carObject.getString("color"));
		System.out.println("name: " + carObject.getString("name"));
		System.out.println("price: " + carObject.getInt("price"));
	}

}

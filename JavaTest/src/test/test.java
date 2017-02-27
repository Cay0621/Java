package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
	
	final static String CITY_RESOURCE = "src/city.txt";
	final static String DISTRICT_RESOURCE = "src/district.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(DISTRICT_RESOURCE)));
		String line = null;
		while((line = reader.readLine()) != null){
			String[] cities = line.split(",");
			String name = cities[1].trim();
			String post = cities[0].trim();
			int city_id = Integer.parseInt(cities[2].trim());
			System.out.println("insert into district values(null, '" + name + "','" + post + "'," + city_id + ");");
		}
	}

}
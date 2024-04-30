package org.selenium.utilities;
import com.github.javafaker.Faker;
public class RandomDataUtility {
	static Faker faker;
	public static String getFirstName()
	{
		faker=new Faker();
		String firstName=faker.name().firstName();
			return firstName;
	}
	public static String getLasttName()
	{
		faker=new Faker();
		String lastName=faker.name().lastName();
		return lastName;
	}
	public static String getTitle()
	{
		faker=new Faker();
		String pageTitle=faker.name().title();
		return pageTitle;
	}
}

package dataProvider;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][]  UserCredentialsData() {
		Object data[][]=new String[3][2];   
		data[0][0]="abmin";      
		data[0][1]="123456";
		
		data[1][0]="admin";      
		data[1][1]="123455";
		
		data[2][0]="adnin";      
		data[2][1]="123466";
		
		return data;
	   }
}

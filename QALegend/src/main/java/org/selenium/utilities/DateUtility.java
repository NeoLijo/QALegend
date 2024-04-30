package org.selenium.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
public static String getUserLoginDate(String format)
{
	DateFormat dateformatobj=new SimpleDateFormat(format); 
	Date currentDateobj=new Date();
	return dateformatobj.format(currentDateobj);
	
}
}

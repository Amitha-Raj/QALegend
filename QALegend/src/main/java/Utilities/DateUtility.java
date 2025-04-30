package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		String formatedDate=dateformat.format(date);
		return formatedDate;
	}

}

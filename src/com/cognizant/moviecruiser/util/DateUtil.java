package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sd.parse(date);
		return d;
	}
}

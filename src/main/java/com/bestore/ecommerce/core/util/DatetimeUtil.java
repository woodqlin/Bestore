package com.bestore.ecommerce.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {
	public static String defaultFormat = "yyyy-MM-dd HH:mm:ss";
	public static Date StringtoDate(String str){
		return StringtoDate(str, defaultFormat);
	}
	public static String DateToStr(Date date){
		return DateToStr(date, defaultFormat);
	}
	public static Date fromTimestamp(long timestamp) throws ParseException{
		SimpleDateFormat format =  new SimpleDateFormat(defaultFormat);  
	    String d = format.format(timestamp);  
	    Date date = format.parse(d);  
	    return date;
	}
	public static Date StringtoDate(String str, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		   Date date = null;
		   try {
		    date = sdf.parse(str);
		   } catch (ParseException e) {
		    e.printStackTrace();
		   }
		   return date;
	}
	
	public static String DateToStr(Date date, String format){
		   SimpleDateFormat sdf = new SimpleDateFormat(format);
		   String str = sdf.format(date);
		   return str;
	}
	public static Date Modifyformat(Date date, String destFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(destFormat);
		String source = sdf.format(date);
		
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestTime {
	@Test
	public void test1() throws ParseException{
//		System.out.println(new Date(System.currentTimeMillis()));
//		System.out.println(new java.sql.Date(System.currentTimeMillis()));
//		System.out.println(new Date());
//		System.out.println(new Date(new Date().getTime()));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date(new Date().getTime());
		String format = simpleDateFormat.format(date);
		System.out.println(format);
		Date tradeTime = simpleDateFormat.parse(format);
		System.out.println(tradeTime);
	}
}

package com.soy.replyrobot.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soy.replyrobot.dao.CommandContentDao;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class TestClass {
	
//	@Autowired
//	private CommandContentDao commandContentDao;
//	@Test
//	public void test1(){
//		boolean b = commandContentDao.existsById(1);
//		System.out.println(b);
//		Assert.assertEquals(true, b);
//	}
	
	@Test
	public void test2(){
		String s = "1111年11月11号";
		Pattern p = Pattern.compile("(\\d*)年(\\d*)月(\\d*)号");
		Matcher m = p.matcher(s);
		if(m.find()){
			System.out.format("年份:%s，月份:%s，日:%s。",m.group(1),m.group(2),m.group(3));
		}
	}
}

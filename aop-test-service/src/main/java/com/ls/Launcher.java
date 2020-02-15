package com.ls;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author LvSheng
 * @date 2020/2/14
 **/
public class Launcher {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		context.start();
		Hello hello = context.getBean("hello", Hello.class);
		hello.hello("lvsheng");
		System.in.read();
	}
}

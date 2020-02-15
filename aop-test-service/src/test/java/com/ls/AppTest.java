package com.ls;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class AppTest {

	@Autowired
	Hello hello;

	@Test
	public void testAop() {
		System.out.println("====================启动服务");
		hello.hello("world");
		System.out.println("====================终止服务");
	}

	@Test
	public void testAopEx() {
		System.out.println("====================启动服务");
		hello.throwEx();
		System.out.println("====================终止服务");
	}

}
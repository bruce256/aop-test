package com.jd.ls;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/6/8.
 */
@Service
public class Hello {
	public String hello(String name) {

		String s = "hello, " + name;
		System.out.println(s);
		return s;
	}

	public void throwEx() {
		throw new NullPointerException();
	}
}

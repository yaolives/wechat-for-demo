package com.yc.wabc.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class Utf8Test {
	/**
	 * utf-8编码
	 */
	public static String urlEncodeUTF8(String source){
		String result = source;
		
		try {
			result = java.net.URLEncoder.encode(source,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Test
	public void test1(){
		String oauthUrl="http://1.wabc.sinaapp.com/OAuthServlet.action";
		System.out.println(urlEncodeUTF8(oauthUrl));
	}
}

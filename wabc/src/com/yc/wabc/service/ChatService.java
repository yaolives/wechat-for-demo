package com.yc.wabc.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.yc.wabc.utils.Constants;
import com.yc.wabc.utils.NetUtil;

public class ChatService {
	public static String chat(String content){
		String message="";
		try {
			message=NetUtil.sendDataByGetRequest3(Constants.SENDPATH3, content+"&type=txt", "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s= message.substring(0, message.lastIndexOf("\""));
		return s.substring(s.lastIndexOf("\"")+1);
	}
	
	public static void main(String args[]){
		System.out.println(chat("衡阳天气"));
	}
}

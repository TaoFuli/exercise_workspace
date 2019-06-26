package com.igeek.app;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.igeek.utils.MailUtils;

public class TestSendMail {

	public static void main(String[] args) 
	{
		
		try {
			MailUtils.sendMail("6157500@qq.com", "注册成功", "注册成功<a href=\"http://www.baidu.com\">百度</a>");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}

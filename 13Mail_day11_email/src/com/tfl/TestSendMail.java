package com.tfl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.jupiter.api.Test;

public class TestSendMail {
	@Test
	//第一，发送文本内容，具体可看api实例
	public void send() throws MessagingException {
		String from="1016206944@qq.com";//发送者
		String frompassword="";
		String to="1007658798@qq.com";//接收邮件的邮箱地址
		String subject="666666测试邮件";		//邮件的标题
		String context="内容为空";			//邮件的内容
		
		//设置发送邮件的配置信息
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");	//指定转发邮件的服务器地址,身份验证
		//填写smtp服务器
		props.put("mail.smtp.host", "smtp.126.com");		//调试设置
		//端口号，邮箱给出有
		props.put("mail.smtp.port", "25");
		//填写个人账号
		props.put("mail.user", from);
		//此处填写邮箱密码，即smtp口令
		props.put("mail.password", frompassword);
		//构建授权信息，用于进行smtp身份验证
		Authenticator authenticator=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			String username=props.getProperty("mail.user");
			String password=props.getProperty("mail.password");
			return new PasswordAuthentication(username,password);
			}
		};
		//使用环境属性和授权信息，创建邮件会话
		
		Session session=Session.getInstance(props,authenticator);	//创建邮件会话
//		session.setDebug(false);				//验证权限    账号和密码
		
		MimeMessage msg=new MimeMessage(session);	//创建一封邮件
		InternetAddress formadd=new InternetAddress(
				props.getProperty("mail.user"));
		msg.setFrom(formadd);;  //设置发送方信息
		
		//设置接收方
		InternetAddress[] add= {new InternetAddress(to)};
		msg.setRecipients(Message.RecipientType.TO,add);
		msg.setSubject(subject);	//添加邮件的标题
		msg.setSentDate(new Date());//添加发送时间
		msg.setText(context);		//设置邮件的文本内容
		
		//最后发送出去
		Transport.send(msg);
		System.out.println("发送完成！");
	}
	
	//第二，添加附件发送
	@Test
	public void send_file() throws MessagingException, IOException {
		String fromuser="1016206944@qq.com";//发件方
		String frompassword="";
		String touser="geek@126.com";//收件方
		String subject="请输入标题";		//邮件主题
		String context="我拍了一些照片，<br/>请查看附件";//邮件的内容
		
		//设置发送邮件的配置信息
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		props.put("mail.user", fromuser);
		props.put("mail.password", frompassword);
		//生成授权信息，进行验证
		Authenticator authenticator=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			String username=props.getProperty("mail.user");
			String password=props.getProperty("mail.password");
			return new PasswordAuthentication(username,password);
			}
		};
		//使用属性和授权信息创建会话
		Session session=Session.getInstance(props,authenticator);
		session.setDebug(false);
		
		//创建一封邮件
		MimeMessage msg=new MimeMessage(session);
		msg.setFrom(fromuser);
		//设置接收方
		InternetAddress[] address= {new InternetAddress(touser)};//数组群发格式
		msg.setRecipients(Message.RecipientType.TO, address);
		//抄送和暗送
//		msg.setRecipients(Message.RecipientType.TO, address);//抄送
//		msg.setRecipients(Message.RecipientType.TO, address);//暗送
		
		//设置邮件的主题
		msg.setSubject(subject);
		msg.setSentDate(new Date());//发送时间
		//msg.setText(context);//设置邮件的文本内容
		
		//第一部分  文本内容
		MimeBodyPart mbp1=new MimeBodyPart();
		mbp1.setText(context);
		//第二部分  文件附件
		MimeBodyPart mbp2=new MimeBodyPart();
		mbp2.attachFile(new File("1.jpg"));
		MimeBodyPart mbp3=new MimeBodyPart();
		mbp3.attachFile(new File(""));
		
		//封装为邮件内容
		MimeMultipart mp=new MimeMultipart();
		mp.addBodyPart(mbp1);
		mp.addBodyPart(mbp2);
		mp.addBodyPart(mbp3);
		//设置内容
		msg.setContent(mp);
		//发送邮件
		Transport.send(msg);
		System.out.println("文件附件发送成功！");
		
		
		
		
		
	}
}

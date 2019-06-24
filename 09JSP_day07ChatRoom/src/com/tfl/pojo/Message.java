package com.tfl.pojo;

import java.util.Date;

/**
 * 聊天信息对象
 */
public class Message {
	private String to; //接收方
	private String from; //发送方
	private String msg; //消息
	private String font; //字体
	private String color; //字体颜色
	private String fontSize; //字体大小
	private Date time; //时间
	
	
	public Message() {
	}
	
	
	public Message(String to, String from, String msg,String font,String color,String fontSize) {
		super();
		this.to = to;
		this.from = from;
		this.msg = msg;
		this.font = font;
		this.color = color;
		this.fontSize = fontSize;
		time = new Date();
	}



	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	public String getFont() {
		return font;
	}


	public void setFont(String font) {
		this.font = font;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getFontSize() {
		return fontSize;
	}


	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	
	@Override
	public String toString() {
		return "<span class='from'>"+from+"</span>对<span class='to'>"+to
				+"</span>说:<span style=\"font-family: '"+font
				+"';color:"+color+";font-size: "+fontSize+";\">"+msg+"</span>";
	}
	
}

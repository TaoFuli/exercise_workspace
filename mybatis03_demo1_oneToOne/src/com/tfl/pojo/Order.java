package com.tfl.pojo;

import java.util.Date;

public class Order {
	private int oid;
	private Date createtime;
	private int orderStatus;
	public Order() {
		super();
	}
	
	public Order(Date createtime, int orderStatus) {
		super();
		this.createtime = createtime;
		this.orderStatus = orderStatus;
	}

	public Order(int oid, Date createtime, int orderStatus) {
		super();
		this.oid = oid;
		this.createtime = createtime;
		this.orderStatus = orderStatus;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", createtime=" + createtime + ", orderStatus=" + orderStatus + "]";
	}
	
}

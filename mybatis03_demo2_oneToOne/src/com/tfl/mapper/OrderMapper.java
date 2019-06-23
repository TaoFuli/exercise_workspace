package com.tfl.mapper;

import java.util.List;

import com.tfl.pojo.Order;
import com.tfl.pojo.OrderUser;

public interface OrderMapper {
	OrderUser selectOrderById(int oid);
	List<Order> selectAllOrder();
}
                                                                                                                                                                                                                                                                                                            